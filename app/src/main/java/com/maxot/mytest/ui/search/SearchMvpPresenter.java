package com.maxot.mytest.ui.search;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface SearchMvpPresenter<V extends  SearchMvpView>
        extends MvpPresenter<V>{
}
