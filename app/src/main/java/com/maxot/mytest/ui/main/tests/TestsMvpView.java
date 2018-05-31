package com.maxot.mytest.ui.main.tests;

import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.ui.basic.MvpView;

import java.util.List;

public interface TestsMvpView extends MvpView {

    void openTestingActivity();

    void openNewTestActivity();

    void updateTests(List<Test> testList);
}
