package com.library.entity;

public class HistoryBookEntity {
    String BookID;
    String BookName;
    String Publisher;
    String ReturnDate;

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

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public HistoryBookEntity(String bookID, String bookName, String publisher, String returnDate) {
        BookID = bookID;
        BookName = bookName;
        Publisher = publisher;
        ReturnDate = returnDate;
    }
}
