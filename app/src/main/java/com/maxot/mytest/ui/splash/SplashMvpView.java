package com.maxot.mytest.ui.splash;

import com.maxot.mytest.ui.basic.MvpView;

public interface SplashMvpView extends MvpView{

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
