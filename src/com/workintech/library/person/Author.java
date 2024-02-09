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

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return getName();
    }
}
