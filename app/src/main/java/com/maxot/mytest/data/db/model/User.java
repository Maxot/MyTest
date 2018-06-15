package com.maxot.mytest.data.db.model;

import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import static com.maxot.mytest.utils.AppConstant.DB_COLLECTION_USER_NAME;

public class User {

    private String email;
    private String name;
    private String phone;
    private String picture;
    private String about;

    public User() {
    }

    public User(String email, String name, String picture) {
        this.email = email;
        this.name = name;
        this.picture = picture;
    }

//    public String getID(){
//        FirebaseFirestore db;
//        db = FirebaseFirestore.getInstance();
//        CollectionReference userRef = db.collection(DB_COLLECTION_USER_NAME);
//        // Create a query against the collection.
//        final Query query = userRef.whereEqualTo("email", email);
//        query.get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        id = queryDocumentSnapshots.getDocuments().get(0).getId();
//                    }
//                });
//        return id;
//    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
