package com.maxot.mytest.ui.profile;

import android.net.Uri;

import com.google.firebase.firestore.DocumentReference;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;

@PerActivity
public interface ProfileMvpPresenter<V extends ProfileMvpView>
        extends MvpPresenter<V>{

    void getResults();

    void getAboutUser();

    void getReviews();

//    void getContact();

 //   String getEmail();

//    String getName();

 //   Uri getProfileImage();

    User getUser(String email);

    DocumentReference getUserRef(String email);

    User getCurrentUser();


}
