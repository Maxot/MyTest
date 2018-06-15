package com.maxot.mytest.data.db.model;

public class CustomTask {

    private String name;
    private String subject;
    private String text;
    private String author;

    public CustomTask() {
    }

    public CustomTask(String name, String subject, String text) {
        this.name = name;
        this.subject = subject;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
