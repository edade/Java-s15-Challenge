package com.workintech.library;
import com.workintech.library.Books.Book;
import com.workintech.library.Books.enums.Category;
import com.workintech.library.Books.enums.Status;
import com.workintech.library.person.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library(List<Book> books, List<Reader> readers) {
        this.books=books;
        this.readers=readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void newBook(Book book) {
        books.add(book);
    }

    public Reader findReaderByBookName(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName) && book.getStatus().equals(Status.BORROWED)) {
                return book.getReader();
            }
        }
        return null;
    } public void borrowBook(int bookId,Reader reader) {
        Book bookToBorrow = findBookById(bookId);
        if (bookToBorrow != null && bookToBorrow.getStatus() == Status.AVAILABLE) {
            bookToBorrow.setStatus(Status.BORROWED);
            bookToBorrow.setReader(reader);
            reader.addBorrowedBook(bookToBorrow);
            double priceToRefund = calculateRefundAmount(bookToBorrow);
            reader.increaseDebt(priceToRefund);
            System.out.println("The book " + bookToBorrow.getName() + " has been borrowed");
            System.out.println(priceToRefund + " dolars taken from reader");
        } else if (bookToBorrow == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            System.out.println("The book " + bookToBorrow.getName() + " is not available for borrowing.");
        }
    }
    public void returnBook(Book book,Reader reader) {
        if (book.getStatus().equals(Status.BORROWED)) {
            book.setStatus(Status.AVAILABLE);
            book.setReader(null);
            double priceToRefund = calculateRefundAmount(book);
            reader.decreaseDebt(priceToRefund);
            reader.getBorrowedBooks().remove(book);
            System.out.println("Book taken back from reader: " + book.getName());
            System.out.println(priceToRefund + " dolars given back to reader");
        } else {
            System.out.println("This book is not borrowed");
        }
    }
    private double calculateRefundAmount(Book book) {
        return book.getPrice();
    }



    public boolean removeBook(int bookId) {
       for(Iterator<Book> iterator =  getBooks().iterator(); iterator.hasNext();){
           Book book = iterator.next();
            if (book.getBook_id() == bookId) {
                iterator.remove();
                return true;
            }
       }
        return false;
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBook_id() == bookId) {
                return book;
            }
        }
        return null;
    }
    public List<Book> listBooksInCategory(Category category) {
        List<Book> booksByCategory = new ArrayList<>();
        boolean foundBooks = false;
        System.out.println("Books by the category " + category + ":");

        for (Book book : books) {
            if (book.getCategory().toString().equalsIgnoreCase(category.toString())) {
                System.out.println(book);
                foundBooks = true;
            }
        }

        if (!foundBooks) {
            System.out.println("No books found by the category ");
        }
        return booksByCategory;
    }

    public List<Book> listBooksByAuthor(String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        boolean foundBooks = false;
        System.out.println("Books by the author " + authorName + ":");

        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                System.out.println(book);
                foundBooks = true;
            }
        }

        if (!foundBooks) {
            System.out.println("No books found by the author " + authorName);
        }
        return booksByAuthor;
    }
    public Book findBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName) ) {
                return book;
            }
        }
        return null;
    }
    public Book findBookByAuthor(String AuthorName) {
        for (Book book : books) {
            if (book.getName().equals(AuthorName) ) {
                return book;
            }
        }
        return null;
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
