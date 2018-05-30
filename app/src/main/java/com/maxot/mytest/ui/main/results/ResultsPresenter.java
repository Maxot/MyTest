package com.maxot.mytest.ui.main.results;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ResultsPresenter<V extends ResultsMvpView> extends BasePresenter<V>
        implements ResultsMvpPresenter<V>{

    @Inject
    public ResultsPresenter(DataManager dataManager,
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
