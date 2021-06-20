package com.library.entity;

public class ViewReservationEntity {
    String BookID;
    String BookName;
    String Publisher;

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

    public ViewReservationEntity(String bookID, String bookName, String publisher) {
        BookID = bookID;
        BookName = bookName;
        Publisher = publisher;
    }
}
