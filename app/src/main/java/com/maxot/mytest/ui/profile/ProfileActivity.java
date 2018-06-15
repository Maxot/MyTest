package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.ui.custom.RoundedImageView;
import com.maxot.mytest.ui.main.MainActivity;
import com.maxot.mytest.ui.result.ResultActivity;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.maxot.mytest.utils.AppConstant.DB_COLLECTION_USER_NAME;

public class ProfileActivity extends BaseActivity
        implements ProfileMvpView, EventListener<DocumentSnapshot> {

    public static final String TAG = "ProfileActivity";

    public static final String USER_ID = "user_id";

    @Inject
    ProfileMvpPresenter<ProfileMvpView> mPresenter;

    @BindView(R.id.profile_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.expandableView)
    ExpandablePlaceHolderView mExpandableView;

    @BindView(R.id.iv_profile_pic)
    RoundedImageView ivProfile;

    @BindView(R.id.tv_prifile_name)
    TextView tvProfileName;



    private ListenerRegistration mUserRegistration;
    private FirebaseFirestore mFirestore;
    private DocumentReference mUserRef;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, ProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
 //       mUserRegistration = mPresenter.getUserRef(userEmail).addSnapshotListener(this);
        mUserRegistration = mUserRef.addSnapshotListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mUserRegistration != null) {
            mUserRegistration.remove();
            mUserRegistration = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        openMainActivity();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    protected void setUp() {

        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mPresenter.getAboutUser();
  //      mPresenter.getContact();
        mPresenter.getResults();
        mPresenter.getReviews();

        // Get user ID from extras
        String userId = getIntent().getExtras().getString(USER_ID);
        if (userId == null) {
            throw new IllegalArgumentException("Must pass extra " + USER_ID);
        }

        mFirestore = FirebaseFirestore.getInstance();

        mUserRef = mFirestore.collection(DB_COLLECTION_USER_NAME).document(userId);

    }

    @Override
    public void updateResults(List<Result> resultList) {
        mExpandableView.addView(new HeadingView(getBaseContext(), "Results"));
        for (int i= 0; i <resultList.size(); i++){
            mExpandableView.addView(new ResultsView(getBaseContext(), resultList.get(i)));
        }
    }

    @Override
    public void updateAboutUser(AboutUser about) {
        mExpandableView.addView(new HeadingView(getBaseContext(), "About"));

        mExpandableView.addView(new AboutUserView(getBaseContext(), about));

    }

    @Override
    public void updateReviews(List<Review> reviews) {
        mExpandableView.addView(new HeadingView(getBaseContext(), "Reviews"));
        for (int i= 0; i < reviews.size(); i++){
            mExpandableView.addView(new ReviewsView(getBaseContext(), reviews.get(i)));
        }

    }

    @Override
    public void updateContacts(User user) {
        mExpandableView.addView(new HeadingView(getBaseContext(),"Contacts"));
            mExpandableView.addView(new ContactsView(getBaseContext(), user));

    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openResultActivity() {
        startActivity(ResultActivity.getStartIntent(this));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemId;
        itemId= item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                openMainActivity();
                break;
        }
        return true;
    }

    @Override
    public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
        if (e != null) {
            Log.w(TAG, "restaurant:onEvent", e);
            return;
        }

     if(documentSnapshot.toObject(User.class) == null){
        onUserLoaded(mPresenter.getCurrentUser());
     } else
        onUserLoaded(documentSnapshot.toObject(User.class));
    }

    private void onUserLoaded(User user) {

        tvProfileName.setText(user.getName());
        Glide.with(ProfileActivity.this)
                .load(user.getPicture())
                .into(ivProfile);

        updateContacts(user);
    }
}
