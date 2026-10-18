import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean borrowed;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }
}

public class LibraryBookBorrowingSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println(
                "ID: " + b.id +
                " | Title: " + b.title +
                " | Author: " + b.author +
                " | Status: " +
                (b.borrowed ? "Borrowed" : "Available")
            );
        }
    }

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    static void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found.");
        } else if (b.borrowed) {
            System.out.println("Book is already borrowed.");
        } else {
            b.borrowed = true;
            System.out.println("Book borrowed successfully!");
        }
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found.");
        } else if (!b.borrowed) {
            System.out.println("This book was not borrowed.");
        } else {
            b.borrowed = false;
            System.out.println("Book returned successfully!");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Library Book Borrowing System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}