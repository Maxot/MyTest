package com.maxot.mytest.ui.result;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.Answer;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.ui.basic.MvpPresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ResultPresenter<V extends ResultMvpView> extends BasePresenter<V>
        implements ResultMvpPresenter<V> {

    public static final String TAG = "ResultPresenter";

    @Inject
    public ResultPresenter(DataManager dataManager,
                           CompositeDisposable compositeDisposable,
                           SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable().add(getDataManager()
                .getAllResult()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Result>>() {
                    @Override
                    public void accept(List<Result> results) throws Exception {

                        getMvpView().updateResults(results);
                    }
                }));
    }
}
