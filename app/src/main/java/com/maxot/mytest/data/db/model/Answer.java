package com.maxot.mytest.data.db.model;

public class Answer{

    private int questionId;

    private String myAnswer;

    public Answer(int questionId, String myAnswer) {
        this.questionId = questionId;
        this.myAnswer = myAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }
}