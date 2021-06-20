package com.library.entity;

public class ReservationEntity {
    private String BookID;
    private String StuID;
    private String ReservationDate;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getStuID() {
        return StuID;
    }

    public void setStuID(String stuID) {
        StuID = stuID;
    }

    public String getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(String reservationDate) {
        ReservationDate = reservationDate;
    }

    public ReservationEntity(String bookID, String stuID, String reservationDate) {
        BookID = bookID;
        StuID = stuID;
        ReservationDate = reservationDate;
    }
}
