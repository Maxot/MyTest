package com.maxot.mytest.data;

import android.content.Context;

import com.maxot.mytest.data.db.DbHelper;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    public static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    @Override
    public Observable<List<Question>> getAllQuestion() {
        return mDbHelper.getAllQuestion();
    }
}
