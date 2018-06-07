package com.maxot.mytest.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.ui.main.MainActivity;
import com.maxot.mytest.ui.result.ResultActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity
        implements SearchMvpView {

    @Inject
    SearchPresenter<SearchMvpView> mPresenter;

    @BindView(R.id.toolbarSearch)
    Toolbar mToolbar;

    @BindView(R.id.search_edit_text)
    EditText mEditTextSearch;


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
}
