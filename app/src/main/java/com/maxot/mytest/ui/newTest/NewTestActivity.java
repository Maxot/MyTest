package com.maxot.mytest.ui.newTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewTestActivity extends BaseActivity implements NewTestMvpView {

    @Inject
    NewTestMvpPresenter<NewTestMvpView> mPresenter;

    @Inject
    NewTestAdapter mNewTestAdapter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.toolbarNewTest)
    Toolbar mToolbar;

    @BindView(R.id.floatingActionButtonForNewQuestion)
    FloatingActionButton mFloatingActionButton;

    @BindView(R.id.new_test_recycler_view)
    RecyclerView mRecyclerView;

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

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mNewTestAdapter);

        mNewTestAdapter.addItem(1);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewTestAdapter.addItem(1);
            }
        });

    }

    @Override
    public void updateCreatingList(List<Integer> mList) {
        mNewTestAdapter.addItems(mList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.new_test_menu, menu);
        return true;
    }
}
