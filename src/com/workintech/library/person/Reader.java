package com.workintech.library.person;

import com.workintech.library.Books.Book;
import com.workintech.library.Books.Status;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;
    public Reader(String name) {
        super(name);
        borrowedBooks = new ArrayList<>();
    }

    @Override
    public void whoyouare() {
        System.out.println("Reader name:"+ getName());
    }

    public void purchaseBook(Book book) {
        System.out.println("Book purchased: " + book.getName());
    }

    public void borrowBook(Book book) {
        if (book.getStatus().equals(Status.AVAILABLE)) {
            book.setStatus(Status.BORROWED);
            borrowedBooks.add(book);
            System.out.println("Book borrowed: " + book.getName());
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.setStatus(Status.AVAILABLE);
            borrowedBooks.remove(book);
            System.out.println("Book returned: " + book.getName());
        } else {
            System.out.println("You haven't borrowed this book.");
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
        return  getName();
    }




}
