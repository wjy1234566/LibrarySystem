package com.library.entity;

public class FeedbackEntity {
    String comments;
    String date;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FeedbackEntity(String comments, String date) {
        this.comments = comments;
        this.date = date;
    }
}
