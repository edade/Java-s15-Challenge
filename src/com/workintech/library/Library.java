package com.workintech.library;

import com.workintech.library.Books.Book;
import com.workintech.library.Books.Status;
import com.workintech.library.person.Reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library(List<Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void newBook(Book book) {
        books.add(book);
        System.out.println("New book added to the library: " + book.getName());
    }

    public void lendBook(Book book, Reader reader) {
        if (book.getStatus().equals(Status.AVAILABLE)) {
            book.setStatus(Status.BORROWED);
            book.setReader(reader);
            reader.borrowBook(book);
            System.out.println("Book lent to reader: " + book.getName());
        } else {
            System.out.println("Book is not available for lending.");
        }
    }

    public void takeBackBook(Book book, Reader reader) {
        if (book.getStatus().equals(Status.BORROWED) && book.getReader().equals(reader)) {
            book.setStatus(Status.AVAILABLE);
            book.setReader(null);
            reader.returnBook(book);
            System.out.println("Book taken back from reader: " + book.getName());
        } else {
            System.out.println("You can't take back this book.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) && Objects.equals(readers, library.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, readers);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
