package me.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTests {

    BookService service;

    @BeforeEach
    void setup() {
        service = new BookService();
    }

    @Test
    @DisplayName("Create service without fail")
    void test_create_service() {
        Assertions.assertDoesNotThrow(() -> {
            new BookService();
        });
    }

    @Test
    @DisplayName("Add book without fail")
    void test_service_add_no_exceptions() {
        Assertions.assertDoesNotThrow(() -> {
            var book = new Book("a", "a", "a", 5.0);
            service.addBook(book);
        });
    }

    @Test
    @DisplayName("Add multiple books without fail")
    void test_service_add_multiple_no_exceptions() {
        Assertions.assertDoesNotThrow(() -> {
            var book = new Book("a", "d", "a", 5.0);
            var book2 = new Book("b", "e", "a", 5.0);
            var book3 = new Book("c", "f", "a", 5.0);
            service.addBook(book);
            service.addBook(book2);
            service.addBook(book3);
        });
    }

    @Test
    @DisplayName("Add duplicate book should throw exception")
    void test_service_add_duplicate_throws_exceptions() {
        var book = new Book("a", "a", "a", 5.0);

        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
        });

        Assertions.assertThrows(BookAlreadyExistsException.class, () -> {
            service.addBook(book);
        });
    }

    @Test
    @DisplayName("Add duplicate name should throw exception")
    void test_service_add_duplicate_name_throws_exceptions() {
        var book = new Book("a", "gyu", "agyu", 5.0);
        var book2 = new Book("a", "cerhhuihipkkk", "agyu", 5.0);

        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
        });

        var exception = Assertions.assertThrows(BookAlreadyExistsException.class, () -> {
            service.addBook(book2);
        });

        Assertions.assertEquals(BookAlreadyExistsException.Type.Name, exception.getType());
    }

    @Test
    @DisplayName("Add duplicate isbn should throw exception")
    void test_service_add_duplicate_isbn_throws_exceptions() {
        var book = new Book("ahui", "gyu", "agyu", 5.0);
        var book2 = new Book("byu", "gyu", "agyu", 5.0);

        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
        });

        var exception = Assertions.assertThrows(BookAlreadyExistsException.class, () -> {
            service.addBook(book2);
        });

        Assertions.assertEquals(BookAlreadyExistsException.Type.ISBN, exception.getType());
    }

    @Test
    @DisplayName("Search should return correct book")
    void test_search_returns_books() {
        var book = new Book("ABC", "1", "agyu", 5.0);
        var book2 = new Book("DEF", "2", "agyu", 5.0);
        var book3 = new Book("HIJ", "3", "agyu", 5.0);

        // This does not technically count as a unit test since we add books using 'addBook'
        // It should be handled using mocking.
        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
            service.addBook(book2);
            service.addBook(book3);
        });

        var result = service.search("A");
        Assertions.assertEquals(List.of(book), result);
    }

    @Test
    @DisplayName("Search should return multiple books")
    void test_search_returns_multiple_books() {
        var book = new Book("ABC", "1", "agyu", 5.0);
        var book2 = new Book("ADEF", "2", "agyu", 5.0);
        var book3 = new Book("HIJ", "3", "agyu", 5.0);

        // This does not technically count as a unit test since we add books using 'addBook'
        // It should be handled using mocking.
        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
            service.addBook(book2);
            service.addBook(book3);
        });

        var result = service.search("A");
        Assertions.assertEquals(List.of(book, book2), result);
    }

    @Test
    @DisplayName("Search should return empty")
    void test_filled_search_returns_multiple_books() {
        var book = new Book("ABC", "1", "agyu", 5.0);
        var book2 = new Book("ADEF", "2", "agyu", 5.0);
        var book3 = new Book("HIJ", "3", "agyu", 5.0);

        // This does not technically count as a unit test since we add books using 'addBook'
        // It should be handled using mocking.
        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
            service.addBook(book2);
            service.addBook(book3);
        });

        var result = service.search("Ö");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Search should return empty")
    void test_search_returns_empty() {
        var result = service.search("A");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Get all should return correct books")
    void test_get_all() {
        var book = new Book("ABC", "1", "agyu", 5.0);
        var book2 = new Book("ADEF", "2", "agyu", 5.0);
        var book3 = new Book("HIJ", "3", "agyu", 5.0);

        // This does not technically count as a unit test since we add books using 'addBook'
        // It should be handled using mocking.
        Assertions.assertDoesNotThrow(() -> {
            service.addBook(book);
            service.addBook(book2);
            service.addBook(book3);
        });

        var result = service.getAllBooks();
        Assertions.assertTrue(result.containsAll(List.of(book, book2, book3)));
    }

    @Test
    @DisplayName("Get all should return empty")
    void test_get_all_empty() {
        var result = service.getAllBooks();
        Assertions.assertTrue(result.isEmpty());
    }
}
