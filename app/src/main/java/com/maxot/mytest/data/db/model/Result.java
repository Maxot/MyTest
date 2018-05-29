package com.maxot.mytest.data.db.model;

import java.util.List;

public class Result {

    private int id;

    private int testId;

    private List<Answer> mAnswers;


    public Result(int id, int testId, List<Answer> answers) {
        this.id = id;
        this.testId = testId;
        mAnswers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<Answer> getAnswers() {
        return mAnswers;
    }

    public void setAnswers(List<Answer> answers) {
        mAnswers = answers;
    }


}
