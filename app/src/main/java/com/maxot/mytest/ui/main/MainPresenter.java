package com.maxot.mytest.ui.main;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.ui.basic.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    public static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onNavMenuCreated() {

    }
}
