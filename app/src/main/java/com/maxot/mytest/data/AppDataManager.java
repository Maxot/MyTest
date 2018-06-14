package com.maxot.mytest.data;

import android.content.Context;
import android.net.Uri;

import com.google.firebase.firestore.Query;
import com.maxot.mytest.data.db.DbHelper;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.data.firebase.FirebaseHelper;
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
    private final FirebaseHelper mFirebaseHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          FirebaseHelper firebaseHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mFirebaseHelper = firebaseHelper;
    }

    @Override
    public void addNewUserToDb() {
        mDbHelper.addNewUserToDb();
    }

    @Override
    public boolean checkIfUserExist() {
        return mDbHelper.checkIfUserExist();
    }

    @Override
    public Query searchUser() {
        return mDbHelper.searchUser();
    }

    @Override
    public Observable<List<Question>> getAllQuestion() {
        return mDbHelper.getAllQuestion();
    }

    @Override
    public Observable<List<Test>> getAllTest() {
        return mDbHelper.getAllTest();
    }

    @Override
    public Observable<List<Result>> getAllResult() {
        return mDbHelper.getAllResult();
    }

    @Override
    public Observable<AboutUser> getAboutUser() {
        return mDbHelper.getAboutUser();
    }

    @Override
    public Observable<List<Review>> getReviews() {
        return mDbHelper.getReviews();
    }

    @Override
    public String getEmail() {
        return mFirebaseHelper.getEmail();
    }

    @Override
    public String getName() {
        return mFirebaseHelper.getName();
    }

    @Override
    public Uri getProfileImg() {
        return mFirebaseHelper.getProfileImg();
    }

    @Override
    public User getUser() {
        return mFirebaseHelper.getUser();
    }
}
