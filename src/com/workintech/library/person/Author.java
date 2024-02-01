package com.workintech.library.person;

import com.workintech.library.Books.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;
    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }



    @Override
    public void whoyouare() {
        System.out.println("Author name" + getName());
    }

    public void newBook( Book book) {
        if (books.contains(book)){
            System.out.println("Author already has this book");
        }else {
            books.add(book);
            System.out.println(book + " is added to author" );
        }
    }
    public void showBook(Book book) {
        System.out.println("Book Details:");
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Status: " + book.getStatus());
        System.out.println("Date of Purchase: " + book.getDate_of_purchase());
    }


    @Override
    public String toString() {
        return getName();
    }
}
