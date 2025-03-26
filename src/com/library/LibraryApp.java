package com.library;

import java.util.*;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryManager manager = new LibraryManager();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1 -> handleAddBook();
                case 2 -> handleViewAllBooks();
                case 3 -> handleSearchById();
                case 4 -> handleSearchByTitle();
                case 5 -> handleUpdateBook();
                case 6 -> handleDeleteBook();
                case 7 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Digital Library Book Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Search Book by Title");
        System.out.println("5. Update Book Details");
        System.out.println("6. Delete Book");
        System.out.println("7. Exit");
    }

    private static void handleAddBook() {
        String id = getStringInput("Enter Book ID: ");
        String title = getNonEmptyString("Enter Title: ");
        String author = getNonEmptyString("Enter Author: ");
        String genre = getStringInput("Enter Genre: ");
        String status = getValidStatus();

        Book book = new Book(id, title, author, genre, status);
        if (manager.addBook(book)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book ID already exists.");
        }
    }

    private static void handleViewAllBooks() {
        List<Book> books = manager.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            printBookTableHeader();
            for (Book book : books) {
                printBookRow(book);
            }
        }
    }

    private static void handleSearchById() {
        String id = getStringInput("Enter Book ID to search: ");
        Book book = manager.searchById(id);
        if (book != null) {
            printBookTableHeader();
            printBookRow(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void handleSearchByTitle() {
        String title = getStringInput("Enter Title to search: ");
        List<Book> books = manager.searchByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            printBookTableHeader();
            for (Book book : books) {
                printBookRow(book);
            }
        }
    }

    private static void handleUpdateBook() {
        String id = getStringInput("Enter Book ID to update: ");
        String title = getNonEmptyString("Enter new Title: ");
        String author = getNonEmptyString("Enter new Author: ");
        String genre = getStringInput("Enter new Genre: ");
        String status = getValidStatus();

        if (manager.updateBook(id, title, author, genre, status)) {
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void handleDeleteBook() {
        String id = getStringInput("Enter Book ID to delete: ");
        if (manager.deleteBook(id)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // ====== Helper Methods ======
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String getNonEmptyString(String prompt) {
        String input;
        do {
            input = getStringInput(prompt);
            if (input.isEmpty()) System.out.println("Input cannot be empty.");
        } while (input.isEmpty());
        return input;
    }

    private static String getValidStatus() {
        String status;
        do {
            status = getStringInput("Enter Availability Status (Available / Checked Out): ");
            if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out")) {
                System.out.println("Invalid status. Please enter 'Available' or 'Checked Out'.");
            }
        } while (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out"));
        return status;
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    // ====== Tabular Display Methods ======
    private static void printBookTableHeader() {
        System.out.printf("%-10s %-20s %-20s %-15s %-15s%n",
            "Book ID", "Title", "Author", "Genre", "Status");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    private static void printBookRow(Book book) {
        System.out.printf("%-10s %-20s %-20s %-15s %-15s%n",
            book.getBookId(),
            book.getTitle(),
            book.getAuthor(),
            book.getGenre(),
            book.getAvailabilityStatus());
    }
}
