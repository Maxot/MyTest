package com.maxot.mytest.ui.newTest;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface NewTestMvpPresenter<V extends NewTestMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
