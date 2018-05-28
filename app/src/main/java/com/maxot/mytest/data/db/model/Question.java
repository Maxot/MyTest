package com.maxot.mytest.data.db.model;

import java.util.List;

public class Question {

    private int id;

    private String questionText;

    private List<Option> optionList;

    public Question(int id, String questionText, List<Option> optionList) {
        this.id = id;
        this.questionText = questionText;
        this.optionList = optionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Option> getOptionList() {
        return optionList;
    }
}
