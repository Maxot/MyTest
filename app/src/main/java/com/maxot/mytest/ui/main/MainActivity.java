package com.maxot.mytest.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import com.maxot.mytest.R;

import com.maxot.mytest.ui.basic.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);



        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    protected void setUp() {

    }
}
