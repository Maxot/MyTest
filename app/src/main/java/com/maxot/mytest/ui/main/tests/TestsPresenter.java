package com.maxot.mytest.ui.main.tests;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class TestsPresenter<V extends TestsMvpView> extends BasePresenter<V>
        implements TestsMvpPresenter<V>{

    @Inject
    public TestsPresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable,
                          SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepared() {

        getCompositeDisposable().add(getDataManager()
                .getAllTest()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Test>>() {
                    @Override
                    public void accept(List<Test> tests) throws Exception {
                        getMvpView().updateTests(tests);
                    }
                }));

    }
}
