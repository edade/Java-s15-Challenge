package com.workintech.library.person;
import com.workintech.library.Books.Book;
import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;
    private double totalDebt;
    public Reader(String name) {
        super(name);
        borrowedBooks = new ArrayList<>();
        this.totalDebt=0.0;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void increaseDebt(double amount) {
        this.totalDebt += amount;
    }

    public void decreaseDebt(double amount) {
        this.totalDebt -= amount;
    }


    @Override
    public String toString() {
        return  getName();
    }



}
