package com.maxot.mytest.data.firebase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.maxot.mytest.data.db.model.User;

import java.net.URL;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppFirebaseHelper implements FirebaseHelper{

    private static final int RC_SIGN_IN = 9001;

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Inject
    public AppFirebaseHelper() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
    }

    @Override
    public String getEmail() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser.getEmail() != null){
            return mFirebaseUser.getEmail();
        } else{
            return "Email";
        }
    }


    @Override
    public String getName() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        return mFirebaseUser.getDisplayName();
    }

    @Override
    public Uri getProfileImg() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        Uri imageUri = mFirebaseUser.getPhotoUrl();

        return imageUri;
    }

    @Override
    public User getUser() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        User mUser = new User(mFirebaseUser.getEmail(),
                mFirebaseUser.getDisplayName(),
                mFirebaseUser.getPhotoUrl().toString());
        return mUser;
    }
}
