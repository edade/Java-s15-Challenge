package com.workintech.library.Books;
import com.workintech.library.Books.enums.Category;
import com.workintech.library.Books.enums.Status;
import com.workintech.library.person.Author;
import com.workintech.library.person.Reader;
import java.util.Objects;

public class Book {
    private int Book_id;
    private Author author;
    private Reader reader;
    private String name;
    private double price;
    private Status status;
    private Category category;

    private  int date_of_purchase;

    public Book(int book_id, Author author, String name, double price, Status status, Category category) {
        Book_id = book_id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category=category;
    }

    public Book(int book_id, Author author, Reader reader, String name, double price, Status status, Category category, int date_of_purchase) {
        Book_id = book_id;
        this.author = author;
        this.reader = reader;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category=category;
        this.date_of_purchase = date_of_purchase;
    }

    public int getBook_id() {
        return Book_id;
    }

    public Author getAuthor() {
        return author;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStatus(Status status) {
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
        System.out.println("reader changed to " + newOwner);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Book_id == book.Book_id && Double.compare(price, book.price) == 0 && date_of_purchase == book.date_of_purchase && Objects.equals(author, book.author) && Objects.equals(reader, book.reader) && Objects.equals(name, book.name) && Objects.equals(status, book.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Book_id, author, reader, name, price, status, date_of_purchase);
    }

    @Override
    public String toString() {
        if (date_of_purchase != 0){
        return "Book{" +
                "Book_id=" + Book_id +
                ", author=" + author +
                ", reader=" + (reader != null ? reader.toString() : "null") +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", category=" + category +
                ", date_of_purchase=" + date_of_purchase +
                '}';}
        else {
           return  "Book{" +
                    "Book_id=" + Book_id +
                    ", author=" + author +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", status='" + status +
                   ", category=" + category +
                    '}';
        }
    }


}
