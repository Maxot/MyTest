package com.maxot.mytest.ui.basic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.maxot.mytest.MvpApp;
import com.maxot.mytest.di.component.ActivityComponent;
import com.maxot.mytest.di.component.DaggerActivityComponent;
import com.maxot.mytest.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }



    protected  abstract void  setUp();
}
