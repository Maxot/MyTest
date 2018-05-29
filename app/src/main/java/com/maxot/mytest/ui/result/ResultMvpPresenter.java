package com.maxot.mytest.ui.result;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface ResultMvpPresenter<V extends ResultMvpView>
        extends MvpPresenter<V>{

    void  onViewPrepared();
}
