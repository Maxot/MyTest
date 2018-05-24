package com.maxot.mytest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.maxot.mytest.R;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.main.MainMvpPresenter;
import com.maxot.mytest.ui.main.MainMvpView;
import com.maxot.mytest.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return  mActivity;
    }

    @Provides
    AppCompatActivity provideActivity(){
        return  mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }




    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
