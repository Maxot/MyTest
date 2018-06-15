package com.maxot.mytest.data.db;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    void addNewUserToDb();

    void addNewTaskToDb(CustomTask task);

 //   boolean checkIfUserExist();

    Query searchUser();

    Query getTasks();

    User getUser(String email);

    String getCurrentUserId();

    DocumentReference getUserRef(String email);

    Observable<List<Question>> getAllQuestion();

    Observable<List<Test>> getAllTest();

    Observable<List<Result>> getAllResult();

    Observable<AboutUser> getAboutUser();

    Observable<List<Review>> getReviews();

}
