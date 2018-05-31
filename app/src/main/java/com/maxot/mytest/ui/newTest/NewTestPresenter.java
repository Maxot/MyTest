package com.maxot.mytest.ui.newTest;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NewTestPresenter<V extends NewTestMvpView> extends BasePresenter<V>
        implements NewTestMvpPresenter<V>{

    public static final String TAG = "NewTestPresenter";

    @Inject
    public NewTestPresenter(DataManager dataManager,
                            CompositeDisposable compositeDisposable,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepared() {

    }
}
