package com.workintech.library.person;

import com.workintech.library.Books.Book;
import com.workintech.library.Books.enums.Status;

import java.util.List;

public class Librarian extends Person {

    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }


    @Override
    public String toString() {
        return "Librarian{" +
                "password=" + password +
                '}';
    }
}
