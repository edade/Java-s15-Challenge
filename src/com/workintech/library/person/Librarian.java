package com.workintech.library.person;

import com.workintech.library.Books.Book;
import com.workintech.library.Books.enums.Status;

import java.util.List;

public class Librarian extends Person {

    private int password;

    public Librarian(String name, int password) {
        super(name);
        this.password = password;
    }

    public int getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Librarian{" +
                "password=" + password +
                '}';
    }
}
