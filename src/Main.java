import com.workintech.library.Books.Book;
import com.workintech.library.Books.enums.Category;
import com.workintech.library.Books.enums.Status;
import com.workintech.library.Library;
import com.workintech.library.person.Author;
import com.workintech.library.person.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String LIBRARIAN_PASSWORD = "default";
    private static Library library = new Library(new ArrayList<>(),new ArrayList<>());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Reader reader1 = new Reader("Ahmet Kaya");
        Reader reader2 = new Reader("Eda Kalaycioglu" );
        Reader reader3 = new Reader("Dogancan Kinik");
        Reader reader4 = new Reader("Yavuz ırmak");

        Author author1 = new Author("Margaret Mitchell");
        Author author2 = new Author("Jane Austen");
        Author author3 = new Author("Harper Lee");
        Author author4 = new Author("Charles Dickens");
        Author author5 = new Author("Lewis Carroll");


        Book book1 = new Book(1,author1,"Gone with the Wind",89, Status.AVAILABLE, Category.NOVEL);
        Book book2 = new Book(2,author2,reader1 ,"Pride and Prejudice",65,Status.BORROWED,Category.JOURNAL,12082023);
        Book book3 = new Book(3,author3,"To Kill a Mockingbird",48,Status.AVAILABLE,Category.MAGAZINES);
        Book book4 = new Book(4,author4,"A Tale of Two Cities",56,Status.AVAILABLE,Category.NOVEL);
        Book book5 = new Book(5,author5,reader3,"Alice’s Adventures in Wonderland",93,Status.BORROWED,Category.JOURNAL,29022024);
        Book book6 = new Book(3,author3,"To Kill a Mockingbird",48,Status.AVAILABLE,Category.MAGAZINES);
        Book book7 = new Book(7,author2,"booknameex",45,Status.AVAILABLE,Category.NOVEL);

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);
        library.getBooks().add(book6);
        library.getBooks().add(book7);

//        System.out.println(library);
//        book2.changeOwner(reader3);
//        System.out.println(library);
//        System.out.println(library.getBooks());

        boolean running = true;
        while (running) {
            System.out.println("Are you a Librarian or a Reader?");
            System.out.println("1. Librarian");
            System.out.println("2. Reader");
            System.out.print("Enter your choice: ");
            int userType = scanner.nextInt();
            scanner.nextLine();

            if (userType == 1) {
                System.out.print("Enter the Librarian password: ");
                String password = scanner.nextLine();
                if (password.equals(LIBRARIAN_PASSWORD)) {
                    librarianActions(scanner);
                } else {
                    System.out.println("Incorrect password. Please try again.");
                }
            } else if (userType == 2) {
                readerActions(scanner);
            } else {
                System.out.println("Invalid choice. Please enter either 1 or 2.");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                running = false;
            }
        }

    }

    private static void librarianActions(Scanner scanner) {
        System.out.println("Librarian actions:");
        System.out.println("1. Add new book");
        System.out.println("2. Choose a book");
        System.out.println("3. Update book information");
        System.out.println("4. Remove book from library");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addNewBook(scanner);
                break;
            case 2:
                chooseBook(scanner);
                break;
            case 3:
                updateBookInformation(scanner);

                break;
            case 4:
                removeBook(scanner);
                break;
            default:
                System.out.println("Invalid selection");
        }
    }

    private static void readerActions(Scanner scanner) {
        System.out.println("Reader actions:");
        System.out.println("1. Borrow a book");
        System.out.println("2. Choose a book");
        System.out.println("3. View available books");
        System.out.println("4. List all books in a category");
        System.out.println("5. List all books of selected author");
        System.out.println("6. Return books");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                borrowBook(scanner);
                System.out.println(library.getBooks());
                break;
            case 2:
                chooseBook(scanner);
                break;
            case 3:
                viewAvailableBooks();
                break;
            case 4:
                listBooksByCategory(scanner);
                break;
            case 5:
                listBooksByAuthor(scanner);
                break;
            case 6:
                returnBook(scanner);
                break;
            default:
                System.out.println("Invalid selection");
        }
    }
    private static void addNewBook(Scanner scanner) {
        System.out.println("book id:");
        int Book_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("author name:");
        String newauthor = scanner.nextLine();
        System.out.println("book name:");
        String name = scanner.nextLine();
        System.out.println("price:");
        double price = scanner.nextDouble();
        System.out.println("category type (1= NOVEL,2= JOURNAL,3= MAGAZINE):");
        int categoryInput = scanner.nextInt();

        Category category;
        switch (categoryInput) {
            case 1:
                category = Category.NOVEL;
                break;
            case 2:
                category = Category.JOURNAL;
                break;
            case 3:
                category = Category.MAGAZINES;
                break;
            default:
                System.out.println("Invalid type");
                return;
        }

        Book book = new Book(Book_id, new Author(newauthor), name, price, Status.AVAILABLE, category);
        library.newBook(book);
        System.out.println("book added");
        System.out.println(library.getBooks());
    }

    public static void chooseBook(Scanner scanner){
        System.out.println("Choose a book :");
        System.out.println("Choose the book according to their ID, name or author");
        String searchQuery = scanner.nextLine();
        boolean bookFound = false;
        for (Book currentBook : library.getBooks()) {
            if (currentBook.getName().equalsIgnoreCase(searchQuery) ||
                    currentBook.getAuthor().getName().equalsIgnoreCase(searchQuery)||
                    String.valueOf(currentBook.getBook_id()).equals(searchQuery)){
                System.out.println("The book is found");
                currentBook.display();
                bookFound = true;

                break;
            }
        }
        if (!bookFound) {
            System.out.println("The book can not be found");
        }
    }
    private static void updateBookInformation(Scanner scanner) {
        System.out.println("Enter the Id of the book you desire to update");
        int bookIDToUpdate = scanner.nextInt();
        scanner.nextLine();
        boolean bookToUpdateFound = false;
        for (Book currentBook : library.getBooks()) {
            if (currentBook.getBook_id() == bookIDToUpdate) {
                System.out.println("Select an option:");
                System.out.println("1. Book name");
                System.out.println("2. Author name");
                System.out.println("3. Price");
                System.out.println("4. Status");
                int updateChoice = scanner.nextInt();
                scanner.nextLine();

                switch (updateChoice) {
                    case 1:
                        System.out.println("Enter new book name");
                        String newName = scanner.nextLine();
                        currentBook.setName(newName);
                        System.out.println("book name updated");
                        System.out.println(currentBook);
                        break;
                    case 2:
                        System.out.println("Enter new author name");
                        String newAuthorName = scanner.nextLine();
                        currentBook.getAuthor().setName(newAuthorName);
                        System.out.println("author name updated");
                        System.out.println(currentBook);

                        break;
                    case 3:
                        System.out.println("Enter new price");
                        double newPrice = scanner.nextDouble();
                        currentBook.setPrice(newPrice);
                        System.out.println("Price updated");
                        System.out.println(currentBook);

                        break;
                    case 4:
                        System.out.println("Enter new Status (AVAILABLE or BORROWED):");
                        String newStatus = scanner.nextLine();
                        currentBook.setStatus(Status.valueOf(newStatus));
                        System.out.println("Status updated");
                        System.out.println(currentBook);

                        break;
                    default:
                        System.out.println("Invalid selection");
                }

                bookToUpdateFound = true;
                break;
            }
        }

        if (!bookToUpdateFound) {
            System.out.println("The book can not be found to update");

        }
    }


    private static void removeBook(Scanner scanner) {
        System.out.println("Remove book:");
        System.out.println("Enter the book id you want to remove:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        boolean removed = library.removeBook(bookId);
        if (removed) {
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.println("Borrow book:");
        System.out.print("Enter the ID of the book you want to borrow: ");
        int borrowBookId = scanner.nextInt();
        System.out.print("Enter your name: ");
        String readerName = scanner.nextLine();
        Reader reader = new Reader(readerName);
        scanner.nextLine();
        library.borrowBook(borrowBookId, reader);

    }

    private static void returnBook(Scanner scanner){
        System.out.println("Return a book:");
        System.out.print("Enter the name of the book to return: ");
        String bookNameToReturn = scanner.nextLine();
        Book bookToReturn = library.findBookByName(bookNameToReturn);
        System.out.println(bookToReturn);
        Reader readerToReturnBook = library.findReaderByBookName(bookNameToReturn);



        if (bookToReturn != null ) {
            library.returnBook(bookToReturn,readerToReturnBook);

        } else {
            System.out.println("Book not found");
        }
        System.out.println(bookToReturn);
    }



    private static void viewAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : library.getBooks()) {
            if (book.getStatus() == Status.AVAILABLE) {
                System.out.println(book);
            }
        }

    }

    private static void listBooksByCategory(Scanner scanner){
        System.out.println("List books in a category:");
        System.out.println("Type (1 for NOVEL, 2 for JOURNAL, 3 for MAGAZINES):");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();
        Category selectedCategory;
        switch (categoryChoice) {
            case 1:
                selectedCategory = Category.NOVEL;
                break;
            case 2:
                selectedCategory = Category.JOURNAL;
                break;
            case 3:
                selectedCategory = Category.MAGAZINES;
                break;
            default:
                System.out.println("Invalid category choice");
                return;
        }

        List<Book> booksInCategory = library.listBooksInCategory(selectedCategory);

        if (booksInCategory.isEmpty()) {
            System.out.println("Book can not be found in selected category");
        } else {
            System.out.println("Books in the category:");
            for (Book currentBook : booksInCategory) {
                System.out.println(currentBook);
            }
        }

    }
    private static void listBooksByAuthor(Scanner scanner) {
        System.out.println("List books by author:");
        System.out.print("Enter the author's name: ");
        String authorName = scanner.nextLine();

        List<Book> booksByAuthor = library.listBooksByAuthor(authorName);
        if (booksByAuthor.isEmpty()) {
            System.out.println("No books found by the author " + authorName);
        } else {
            System.out.println("Books by the author " + authorName + ":");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        }
    }
}