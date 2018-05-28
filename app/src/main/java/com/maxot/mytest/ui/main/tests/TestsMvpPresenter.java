package com.maxot.mytest.ui.main.tests;

import com.maxot.mytest.ui.basic.MvpPresenter;

public interface TestsMvpPresenter<V extends TestsMvpView>
        extends MvpPresenter<V>{

    void  onViewPrepared();
}
