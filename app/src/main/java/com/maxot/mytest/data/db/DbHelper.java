package com.maxot.mytest.data.db;

import com.maxot.mytest.data.db.model.Question;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<Question>> getAllQuestion();

}
