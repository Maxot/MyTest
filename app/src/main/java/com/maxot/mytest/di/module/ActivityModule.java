package com.maxot.mytest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.maxot.mytest.R;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpView;
import com.maxot.mytest.ui.main.MainMvpPresenter;
import com.maxot.mytest.ui.main.MainMvpView;
import com.maxot.mytest.ui.main.MainPagerAdapter;
import com.maxot.mytest.ui.main.MainPresenter;
import com.maxot.mytest.ui.main.tests.TestsAdapter;
import com.maxot.mytest.ui.main.tests.TestsMvpPresenter;
import com.maxot.mytest.ui.main.tests.TestsMvpView;
import com.maxot.mytest.ui.main.tests.TestsPresenter;

import java.util.ArrayList;

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
    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity){
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    TestsAdapter provideTestsAdapter(){
        return new TestsAdapter();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    TestsMvpPresenter<TestsMvpView> provideTestsMvpPresenter(
            TestsPresenter<TestsMvpView> presenter) {
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

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
