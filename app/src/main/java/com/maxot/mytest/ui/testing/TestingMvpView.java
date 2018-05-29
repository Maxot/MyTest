package com.maxot.mytest.ui.testing;

import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.ui.basic.MvpView;

import java.util.List;

public interface TestingMvpView extends MvpView {

    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);

    void openResultActivity();
}
