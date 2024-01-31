package com.workintech.library.Books;

import com.workintech.library.person.Author;
import com.workintech.library.person.Reader;

public abstract class Book {
    private int Book_id;
    private Author author;
    private Reader reader;
    private String name;
    private double price;
    private String status;
    private  int date_of_purchase;

    public Book(int book_id, Author author,Reader reader, String name, double price, String status) {
        Book_id = book_id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public Book(int book_id, Author author, Reader reader, String name, double price, String status, int date_of_purchase) {
        Book_id = book_id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.date_of_purchase = date_of_purchase;
    }

    public int getBook_id() {
        return Book_id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDate_of_purchase() {
        return date_of_purchase;
    }

    public Reader getOwner(){
        return this.reader;
    }
    public void changeOwner(Reader newOwner){
        this.reader = newOwner;
        System.out.println("reader changed to" + newOwner);
    }

    public void display() {
        System.out.println("Book ID: " + Book_id);
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Status: " + status);
        System.out.println("Date of Purchase: " + date_of_purchase);
    }




    @Override
    public String toString() {
        return "Book{" +
                "Book_id=" + Book_id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }
}
