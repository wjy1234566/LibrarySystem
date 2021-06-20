package com.library.entity;

import java.util.List;

public class BookEntity {
    private String BookID;
    private String BookName;
    private String author;
    private String price;
    private String publisher;
    private Integer quantity;
    private String BookClass;
    private String BookSurface;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBookClass() {
        return BookClass;
    }

    public void setBookClass(String bookClass) {
        BookClass = bookClass;
    }

    public String getBookSurface() {
        return BookSurface;
    }

    public void setBookSurface(String bookSurface) {
        BookSurface = bookSurface;
    }

    public BookEntity(String bookID, String bookName, String author, String price, String publisher, Integer quantity, String bookClass, String bookSurface) {
        BookID = bookID;
        BookName = bookName;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.quantity = quantity;
        BookClass = bookClass;
        BookSurface = bookSurface;
    }

}
