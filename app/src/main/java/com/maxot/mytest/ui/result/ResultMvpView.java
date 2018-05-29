package com.maxot.mytest.ui.result;

import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.MvpView;

import java.util.List;

public interface ResultMvpView extends MvpView {

    void updateResults(List<Result> resultList);
}
