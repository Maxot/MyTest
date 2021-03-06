package com.maxot.mytest.ui.main;

import android.net.Uri;

import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void onNavMenuCreated();

    void onDrawerOptionProfileClick();

    void onDrawerOptionAboutClick();

    void onDrawerOptionLogoutClick();

//    String getEmail();
//
//    String getName();
//
//    Uri getProfilImage();

    User getCurrentUser();

    String getCurrentUseID();
}
