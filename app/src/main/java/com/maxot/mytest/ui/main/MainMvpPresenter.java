package com.maxot.mytest.ui.main;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void onNavMenuCreated();

}
