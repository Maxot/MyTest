package com.maxot.mytest.ui.main.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseFragment;

public class ResultsFragment extends BaseFragment implements
        ResultsMvpView, ResultsAdapter.Callback{

    public static final String TAG = "ResultsFragment";

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

        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onTestsEmptyViewRetryClick() {

    }
}
