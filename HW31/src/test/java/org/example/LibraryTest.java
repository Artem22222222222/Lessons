package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    static Library fullLibrary;
    static Book book1;
    static Book book2;

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        book1 = new Book("me", "super book");
        book2 = new Book("person", "good book");
    }
    @org.junit.jupiter.api.BeforeEach
    void setFullLibrary(){
        fullLibrary = new Library();
    }

    @org.junit.jupiter.api.Test
    void addOneBook_LibraryContainOneBook(){

        assertEquals(0, fullLibrary.getBookCount());
        assertTrue(fullLibrary.addBook(book1));
        assertTrue(fullLibrary.getBooks().contains(book1));
        assertEquals(1, fullLibrary.getBookCount());
    }

    @org.junit.jupiter.api.Test
    void addNull_BookWasNotAdded(){
        assertEquals(0, fullLibrary.getBookCount());
        assertFalse(fullLibrary.addBook(null));
        assertFalse(fullLibrary.getBooks().contains(null));
        assertEquals(0, fullLibrary.getBookCount());
    }

    @org.junit.jupiter.api.Test
    void removeOneBook_LibraryDoesNotContainTheBook() {

        fullLibrary.addBook(book1);

        assertTrue(fullLibrary.removeBook(book1));
        assertFalse(fullLibrary.getBooks().contains(book1));
    }

    @org.junit.jupiter.api.Test
    void removeNotExistedBook_LibraryIsNotChanged(){
        fullLibrary.addBook(book1);

        assertFalse(fullLibrary.removeBook(book2));
        assertEquals(1, fullLibrary.getBookCount());
    }


    @org.junit.jupiter.api.Test
    void getBooks() {
        fullLibrary.addBook(book1);

        assertEquals(List.of(book1), fullLibrary.getBooks());
    }

    @org.junit.jupiter.api.Test
    void getBookCount() {
        fullLibrary.addBook(book1);

        assertEquals(1, fullLibrary.getBookCount());
    }
}