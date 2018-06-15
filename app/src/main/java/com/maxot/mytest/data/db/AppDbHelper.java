package com.maxot.mytest.data.db;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Answer;
import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.data.db.model.Option;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.data.db.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static com.maxot.mytest.utils.AppConstant.DB_COLLECTION_TASK_NAME;
import static com.maxot.mytest.utils.AppConstant.DB_COLLECTION_USER_NAME;

@Singleton
public class AppDbHelper implements DbHelper {

    private FirebaseFirestore db;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DocumentSnapshot documentSnapshot;
    private Query mQuery;
    private User mUser;
    private DocumentReference mUserRef;

    @Inject
    public AppDbHelper() {
        db = FirebaseFirestore.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
    }

    @Override
    public void addNewUserToDb() {

            mFirebaseAuth = FirebaseAuth.getInstance();

            mFirebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {

                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                    if (firebaseAuth.getCurrentUser() != null) {
                        mFirebaseUser = firebaseAuth.getCurrentUser();

                        // Create a reference to the user collection
                        CollectionReference userRef = db.collection(DB_COLLECTION_USER_NAME);
                        // Create a query against the collection.
                        final Query query = userRef.whereEqualTo("email", firebaseAuth.getCurrentUser().getEmail());
                        query.get()
                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                    @Override
                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                        if(queryDocumentSnapshots.size() == 0){
                                            User user = new User(mFirebaseUser.getEmail(), mFirebaseUser.getDisplayName(), mFirebaseUser.getPhotoUrl().toString());
                                            db.collection(DB_COLLECTION_USER_NAME).document().set(user);
                                        }
                                    }
                                });
                    }
                }

            });
    }

    @Override
    public void addNewTaskToDb(CustomTask task) {
        db.collection(DB_COLLECTION_TASK_NAME).document().set(task);
    }

    @Override
    public Query searchUser() {
        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Get users
        mQuery = db.collection(DB_COLLECTION_USER_NAME);
        return mQuery;
    }

    @Override
    public Query getTasks() {
        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Get users
        mQuery = db.collection(DB_COLLECTION_TASK_NAME);
        return mQuery;
    }

    @Override
    public User getUser(String email) {
        CollectionReference userRef = db.collection(DB_COLLECTION_USER_NAME);
        // Create a query against the collection.
        final Query query = userRef.whereEqualTo("email", email);
        query.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        mUser = queryDocumentSnapshots.getDocuments().get(0).toObject(User.class);
                    }
                });
        return mUser;
    }

    @Override
    public String getCurrentUserId() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        return mFirebaseUser.getProviderId();
    }

    @Override
    public DocumentReference getUserRef(String email) {
        CollectionReference userRef = db.collection(DB_COLLECTION_USER_NAME);
        // Create a query against the collection.
        final Query query = userRef.whereEqualTo("email", email);
        query.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        mUserRef = queryDocumentSnapshots.getDocuments().get(0).getReference();
                    }
                });
        return mUserRef;
    }

    @Override
    public Observable<List<Question>> getAllQuestion() {

        List<Question> questions = new ArrayList<Question>();
        List<Option> options = new ArrayList<Option>();
        List<Option> options2 = new ArrayList<Option>();
        options.add(new Option(1, "5", 1, false));
        options.add(new Option(2, "10", 1, true));
        options.add(new Option(3, "15", 1, false));
        questions.add(new Question(1, "5+5", options));

        options2.add(new Option(1, "50", 2, false));
        options2.add(new Option(2, "100", 2, true));
        options2.add(new Option(3, "150", 2, false));
        questions.add(new Question(2, "50+50", options2));

        Observable<List<Question>> myQuestions = Observable.just(questions);

        return myQuestions;
    }

    @Override
    public Observable<List<Test>> getAllTest() {

        List<Test> tests = new ArrayList<Test>();

        Test mathTest = new Test(1,"Math test");
        Test androidTest = new Test(2,"Android test");
        Test cppTest = new Test(3,"C++ test");
        Test rubyTest = new Test(3,"Ruby test");


        tests.add(mathTest);
        tests.add(androidTest);
        tests.add(cppTest);
        tests.add(rubyTest);

        Observable<List<Test>> myTests = Observable.just(tests);
        return myTests;
    }

    @Override
    public Observable<List<Result>> getAllResult() {

        List<Result> results = new ArrayList<Result>();
        List<Answer> answers = new ArrayList<Answer>();

        List<Answer> answers1 = new ArrayList<Answer>();
        answers.add(new Answer(1,"myAnswer1"));
        answers.add(new Answer(2,"myAnswer12"));
        answers.add(new Answer(3,"myAnswer13"));

        answers1.add(new Answer(4,"myAnswer1453"));
        answers1.add(new Answer(5,"myAnswer153"));
        answers1.add(new Answer(6,"myAnswer163"));


        results.add(new Result(1, 1, answers));
        results.add(new Result(2, 2, answers1));
        results.add(new Result(3, 3, answers1));
        results.add(new Result(4, 4, answers1));


        Observable<List<Result>> myResults = Observable.just(results);
        return myResults;
    }

    @Override
    public Observable<AboutUser> getAboutUser() {

        AboutUser aboutUser = new AboutUser("Android developer, la;alalalalalalalalalalala");

        Observable<AboutUser> myAbout = Observable.just(aboutUser);
        return myAbout;
    }

    @Override
    public Observable<List<Review>> getReviews() {
        Review review1 = new Review("Good work!");
        Review review2 = new Review("Well done!");
        List<Review> list = new ArrayList<>();
        list.add(review1);
        list.add(review2);

        Observable<List<Review>> listObservable = Observable.just(list);
        return  listObservable;
    }
}
