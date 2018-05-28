package com.maxot.mytest.ui.testing;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;
import com.maxot.mytest.ui.basic.MvpView;

@PerActivity
public interface TestingMvpPresenter<V extends TestingMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

}
