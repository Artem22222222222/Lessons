package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (book != null) {
            return books.add(book);
        } else {
            return false;
        }
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }
}
