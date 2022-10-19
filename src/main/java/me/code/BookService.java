package me.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookService {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) throws BookAlreadyExistsException {
        if (books.containsKey(book.getName())) {
            throw new BookAlreadyExistsException(BookAlreadyExistsException.Type.Name);
        } else if (getByISBN(book.getIsbn()) != null) {
            throw new BookAlreadyExistsException(BookAlreadyExistsException.Type.ISBN);
        }

        books.put(book.getName(), book);
    }

    public Book getByISBN(String isbn) {
        for (var entry : books.entrySet()) {
            if (entry.getValue().getIsbn().equals(isbn)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void removeBook(String isbn) {}

    public void removeBook(Book book) {}

    public Collection<Book> search(String name) {
        var searched = new ArrayList<Book>();

        for (var entry : books.entrySet()) {
            var bookName = entry.getValue().getName();
            if (bookName.toLowerCase().contains(name.toLowerCase())) {
                searched.add(entry.getValue());
            }
        }

        return searched;
    }

    public Collection<Book> getAllBooks() {
        return this.books.values();
    }
}
