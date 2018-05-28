package com.maxot.mytest.data.db;

import com.maxot.mytest.data.db.model.Option;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    @Inject
    public AppDbHelper() {
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

        tests.add(mathTest);
        tests.add(androidTest);
        tests.add(cppTest);

        Observable<List<Test>> myTests = Observable.just(tests);
        return myTests;
    }
}
