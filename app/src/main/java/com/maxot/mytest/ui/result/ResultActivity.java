package com.maxot.mytest.ui.result;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Answer;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.ui.main.results.ResultsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends BaseActivity
        implements ResultMvpView, ResultAdapter.Callback {

    @Inject
    ResultMvpPresenter<ResultMvpView> mPresenter;

    @Inject
    ResultAdapter mResultAdapter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.result_recycler_view)
    RecyclerView mRecyclerView;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, ResultActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        mResultAdapter.setCallback(this);

        setUp();
    }

    @Override
    protected void setUp() {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mResultAdapter);
        mPresenter.onViewPrepared();

    }

    @Override
    public void updateResults(List<Result> resultList) {
        mResultAdapter.addItems(resultList);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onRepoEmptyViewRetryClick() {

    }
}
