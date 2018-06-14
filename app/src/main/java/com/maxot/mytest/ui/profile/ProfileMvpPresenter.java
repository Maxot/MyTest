package com.maxot.mytest.ui.profile;

import android.net.Uri;

import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface ProfileMvpPresenter<V extends ProfileMvpView>
        extends MvpPresenter<V>{

    void getResults();

    void getAboutUser();

    void getReviews();

    void getContact();

    User getUser();

    String getEmail();

    String getName();

    Uri getProfileImage();


}
