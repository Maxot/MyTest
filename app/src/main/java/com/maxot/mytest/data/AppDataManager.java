package com.maxot.mytest.data;

import android.content.Context;

import com.maxot.mytest.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    public static final String TAG = "AppDataManager";

    private final Context mContext;

    @Inject
    public AppDataManager(@ApplicationContext Context context) {
        mContext = context;
    }
}
