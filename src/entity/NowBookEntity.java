package com.library.entity;

public class NowBookEntity {
    String BookID;
    String BookName;
    String Publisher;
    String DueDate;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public NowBookEntity(String bookID, String bookName, String publisher, String dueDate) {
        BookID = bookID;
        BookName = bookName;
        Publisher = publisher;
        DueDate = dueDate;
    }
}
