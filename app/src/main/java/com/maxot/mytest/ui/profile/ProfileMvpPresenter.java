package com.maxot.mytest.ui.profile;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface ProfileMvpPresenter<V extends ProfileMvpView>
        extends MvpPresenter<V>{

    void getResults();

    void getAboutUser();

    void getReviews();

}
