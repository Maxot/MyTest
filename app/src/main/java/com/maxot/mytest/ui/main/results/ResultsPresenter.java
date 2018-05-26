package com.maxot.mytest.ui.main.results;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ResultsPresenter<V extends ResultsMvpView> extends BasePresenter<V>
        implements ResultsMvpPresenter<V>{

    @Inject
    public ResultsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
}
