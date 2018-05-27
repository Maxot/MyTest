package com.maxot.mytest.ui.testing;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TestingPresenter<V extends TestingMvpView> extends BasePresenter<V>
        implements TestingMvpPresenter<V>{

    public static final String TAG = "TestingPresenter";

    @Inject
    public TestingPresenter(DataManager dataManager,
                            CompositeDisposable compositeDisposable,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewInitialized() {

    }
}
