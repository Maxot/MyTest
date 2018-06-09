package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
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

public class ProfileActivity extends BaseActivity
        implements ProfileMvpView{

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
    public void onBackPressed() {
        super.onBackPressed();
        openMainActivity();
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
        mPresenter.getResults();
        mPresenter.getReviews();



        tvProfileName.setText(mPresenter.getName());
        Glide.with(ProfileActivity.this)
                .load(mPresenter.getProfileImage())
                .into(ivProfile);

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
    public void openMainActivity() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openResultActivity() {
        startActivity(ResultActivity.getStartIntent(this));
        finish();
    }
}
