package com.maxot.mytest.data.firebase;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.maxot.mytest.R;

import static android.provider.Settings.Global.getString;

public class Auth {

    private FirebaseAuth mFirebaseAuth;

    private FirebaseUser mFirebaseUser;

    public void signIn(){
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             //   .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


    }
}
