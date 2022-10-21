package me.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) throws BookAlreadyExistsException {
        if (repository.getByName(book.getName()).isPresent()) {
            throw new BookAlreadyExistsException(BookAlreadyExistsException.Type.Name);
        } else if (getByISBN(book.getIsbn()) != null) {
            throw new BookAlreadyExistsException(BookAlreadyExistsException.Type.ISBN);
        }

        repository.save(book);
    }

    public Book getByISBN(String isbn) {
        for (var book : repository.getAll()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    public void removeBook(String name) throws BookNotFoundException {
        var existing = this.repository.getByName(name);
        if (existing.isEmpty()) {
            throw new BookNotFoundException();
        }

        this.removeBook(existing.get());
    }

    public void removeBook(Book book) {
        this.repository.remove(book);
    }

    public Collection<Book> search(String name) {
        var searched = new ArrayList<Book>();

        for (var book : repository.getAll()) {
            var bookName = book.getName();
            if (bookName.toLowerCase().contains(name.toLowerCase())) {
                searched.add(book);
            }
        }

        return searched;
    }

    public Collection<Book> getAllBooks() {
        return this.repository.getAll();
    }
}
