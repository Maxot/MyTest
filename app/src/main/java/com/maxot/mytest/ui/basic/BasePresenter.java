package com.maxot.mytest.ui.basic;

import com.maxot.mytest.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;


    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable){
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mvpView = mMvpView;

    }

    @Override
    public void onDetach() {

    }
}
