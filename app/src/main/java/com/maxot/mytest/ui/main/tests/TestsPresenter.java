package com.maxot.mytest.ui.main.tests;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TestsPresenter<V extends TestsMvpView> extends BasePresenter<V>
        implements TestsMvpPresenter<V>{

    @Inject
    public TestsPresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable,
                          SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepader() {

    }
}
