package com.library;

import java.util.*;

public class LibraryManager {
    private final Map<String, Book> bookCatalog = new HashMap<>();

    public boolean addBook(Book book) {
        if (bookCatalog.containsKey(book.getBookId())) return false;
        bookCatalog.put(book.getBookId(), book);
        return true;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookCatalog.values());
    }

    public Book searchById(String id) {
        return bookCatalog.get(id);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean updateBook(String id, String title, String author, String genre, String status) {
        Book book = bookCatalog.get(id);
        if (book == null) return false;

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailabilityStatus(status);
        return true;
    }

    public boolean deleteBook(String id) {
        return bookCatalog.remove(id) != null;
    }
}
