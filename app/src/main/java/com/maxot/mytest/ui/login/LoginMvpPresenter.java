package com.maxot.mytest.ui.login;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
