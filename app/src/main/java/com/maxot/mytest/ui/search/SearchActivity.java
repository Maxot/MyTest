package com.maxot.mytest.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.ui.main.MainActivity;
import com.maxot.mytest.ui.result.ResultActivity;
import com.maxot.mytest.ui.search.user.UserAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.maxot.mytest.utils.AppConstant.DB_COLLECTION_USER_NAME;

public class SearchActivity extends BaseActivity
        implements SearchMvpView, UserAdapter.OnUserSelectedListener{

    @Inject
    SearchPresenter<SearchMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    UserAdapter mAdapter;

    @BindView(R.id.toolbarSearch)
    Toolbar mToolbar;

    @BindView(R.id.search_edit_text)
    EditText mEditTextSearch;

    @BindView(R.id.user_recycler_view)
    RecyclerView mUserRecycler;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    public void onStart() {
        super.onStart();

        // Start sign in if necessary
  //      if (shouldStartSignIn()) {
 //           startSignIn();
  //          return;
//        }

        // Apply filters
 //       onFilter(mViewModel.getFilters());

        // Start listening for Firestore updates
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        showKeyboard();

        // RecyclerView
        mAdapter = new UserAdapter(mPresenter.searchUser(), this) {
            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mUserRecycler.setVisibility(View.GONE);
               //     mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mUserRecycler.setVisibility(View.VISIBLE);
               //     mEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
                Snackbar.make(findViewById(android.R.id.content),
                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
            }
        };

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUserRecycler.setLayoutManager(mLinearLayoutManager);
        mUserRecycler.setAdapter(mAdapter);

        // Filter Dialog
   //     mFilterDialog = new FilterDialogFragment();

    }

    @Override
    public void showKeyboard() {
        mEditTextSearch.postDelayed(new Runnable() { @Override public void run() {
            InputMethodManager keyboard = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            keyboard.showSoftInput(mEditTextSearch, 0); } },50);
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
            case R.id.action_clear:
                mEditTextSearch.setText("");

                // Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void onUserSelected(DocumentSnapshot restaurant) {

    }
}
