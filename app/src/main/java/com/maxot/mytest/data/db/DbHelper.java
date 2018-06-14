package com.maxot.mytest.data.db;

import com.google.firebase.firestore.Query;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.Test;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    void addNewUserToDb();

    boolean checkIfUserExist();

    Query searchUser();

    Observable<List<Question>> getAllQuestion();

    Observable<List<Test>> getAllTest();

    Observable<List<Result>> getAllResult();

    Observable<AboutUser> getAboutUser();

    Observable<List<Review>> getReviews();

}
