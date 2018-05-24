package com.maxot.mytest.di.component;

import android.content.Context;

import com.maxot.mytest.MvpApp;
import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.ApplicationContext;
import com.maxot.mytest.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context getContext();

    DataManager getDataManager();
}
