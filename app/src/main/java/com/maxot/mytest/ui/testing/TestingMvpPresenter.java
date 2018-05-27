package com.maxot.mytest.ui.testing;

import com.maxot.mytest.ui.basic.MvpPresenter;
import com.maxot.mytest.ui.basic.MvpView;

public interface TestingMvpPresenter<V extends TestingMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

}
