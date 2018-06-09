package com.maxot.mytest.di.module;

import android.app.Application;
import android.content.Context;

import com.maxot.mytest.R;
import com.maxot.mytest.data.AppDataManager;
import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.AppDbHelper;
import com.maxot.mytest.data.db.DbHelper;
import com.maxot.mytest.data.firebase.AppFirebaseHelper;
import com.maxot.mytest.data.firebase.FirebaseHelper;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

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

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    FirebaseHelper provideFirebaseHelper(AppFirebaseHelper appFirebaseHelper) {
        return appFirebaseHelper;
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
