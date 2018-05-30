package com.maxot.mytest.ui.main.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.di.component.ActivityComponent;
import com.maxot.mytest.ui.basic.BaseFragment;
import com.maxot.mytest.ui.result.ResultActivity;
import com.maxot.mytest.ui.result.ResultMvpPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsFragment extends BaseFragment implements
        ResultsMvpView, ResultsAdapter.Callback{

    public static final String TAG = "ResultsFragment";

    @Inject
    ResultsMvpPresenter<ResultsMvpView> mPresenter;

    @Inject
    ResultsAdapter mResultsAdapter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.results_recycler_view)
    RecyclerView mRecyclerView;

    public static ResultsFragment newInstance(){
        Bundle args = new Bundle();
        ResultsFragment fragment = new ResultsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_results, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mResultsAdapter.setCallback(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mResultsAdapter);


        mPresenter.onViewPrepared();

    }

    @Override
    public void onTestsEmptyViewRetryClick() {

    }

    @Override
    public void openResultActivity() {
        startActivity(ResultActivity.getStartIntent(this.getContext()));
    }

    @Override
    public void updateResults(List<Result> resultList) {
        mResultsAdapter.addItems(resultList);

    }
}
