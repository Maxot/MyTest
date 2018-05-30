package com.maxot.mytest.ui.main.results;

import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.MvpView;

import java.util.List;

public interface ResultsMvpView extends MvpView {

    void updateResults(List<Result> resultList);

    void openResultActivity();
}
