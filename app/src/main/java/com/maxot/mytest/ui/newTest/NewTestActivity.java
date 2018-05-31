package com.maxot.mytest.ui.newTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewTestActivity extends BaseActivity implements NewTestMvpView {

    @Inject
    NewTestMvpPresenter<NewTestMvpView> mPresenter;

    @BindView(R.id.toolbarNewTest)
    Toolbar mToolbar;



    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, NewTestActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);

        getActivityComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }


    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.new_test_menu, menu);
        return true;
    }
}
