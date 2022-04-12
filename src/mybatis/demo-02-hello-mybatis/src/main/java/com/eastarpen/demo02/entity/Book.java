package com.eastarpen.demo02.entity;

public class Book {

    private int id;
    private String bookName;
    private String author;
    private int inventory;
    private String description;

    public Book() { }

    public Book(int id, String bookName, String author, int inventory, String description) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.inventory = inventory;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", inventory=" + inventory +
                ", description='" + description + '\'' +
                '}';
    }
}
