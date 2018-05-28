package com.maxot.mytest.ui.main.tests;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.di.component.ActivityComponent;
import com.maxot.mytest.ui.basic.BaseFragment;
import com.maxot.mytest.ui.testing.TestingActivity;
import com.mindorks.placeholderview.annotations.Click;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestsFragment extends BaseFragment
        implements TestsMvpView, TestsAdapter.Callback{

    public static final String TAG = "TestsFragment";

    @Inject
    TestsMvpPresenter<TestsMvpView> mPresenter;

    @Inject
    TestsAdapter mTestsAdapter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.tests_recycler_view)
    RecyclerView mRecyclerView;



    public static TestsFragment newInstance(){
        Bundle args = new Bundle();
        TestsFragment fragment = new TestsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tests, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mTestsAdapter.setCallback(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mTestsAdapter);


        mPresenter.onViewPrepared();

    }

    @Override
    public void onTestsEmptyViewRetryClick() {

    }

    @Override
    public void updateTests(List<Test> testList) {
        mTestsAdapter.addItems(testList);
    }

    @Override
    public void openTestingActivity() {
        startActivity(TestingActivity.getStartIntent(this.getContext()));
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
