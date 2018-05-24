package com.maxot.mytest.di.module;

import android.app.Application;
import android.content.Context;

import com.maxot.mytest.data.AppDataManager;
import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager prodiveDataManager(AppDataManager appDataManager){
        return  appDataManager;
    }
}
