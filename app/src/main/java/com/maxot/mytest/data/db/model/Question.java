package com.maxot.mytest.data.db.model;

import java.util.List;

public class Question {

    private Long id;

    private String questionText;

    private List<Option> optionList;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Option> getOptionList() {
        return optionList;
    }
}
