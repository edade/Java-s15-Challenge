package com.workintech.library.person;

import com.workintech.library.Books.Book;
import com.workintech.library.Books.Status;

import java.util.List;

public class Librarian extends Person {

    private int password;

    public Librarian(String name, int password) {
        super(name);
        this.password = password;
    }

    @Override
    public void whoyouare() {
        System.out.println("the person is a librarian "  );
    }
    public Book searchBook(List<Book> books, String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }


    public boolean verifyMember(Reader reader, String memberName) {
        return reader.getName().equals(memberName) ;
    }


    public void createBill(Reader reader, double amount) {
        System.out.println("The bill is created. Reader: " + reader.getName() + ", Price: " + amount);
    }


    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        book.setStatus(Status.AVAILABLE);
        System.out.println("The book returned back successfully: " + book.getName());
    }
}
