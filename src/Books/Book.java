package Books;

import person.Author;

public class Book {
    private int Book_id;
    private Author author;
    private String name;
    private double price;
    private String status;
    private  int date_of_purchase;

    public Book(int book_id, Author author, String name, double price, String status) {
        Book_id = book_id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public Book(int book_id, Author author, String name, double price, String status, int date_of_purchase) {
        Book_id = book_id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.date_of_purchase = date_of_purchase;
    }

    public int getBook_id() {
        return Book_id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDate_of_purchase() {
        return date_of_purchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Book_id=" + Book_id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }
}
