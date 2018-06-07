package com.maxot.mytest;

import android.app.Application;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.di.component.ApplicationComponent;
import com.maxot.mytest.di.component.DaggerApplicationComponent;
import com.maxot.mytest.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
   CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        CalligraphyConfig.initDefault(mCalligraphyConfig);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
