package me.code;

import java.util.Collection;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> getByName(String name);
    Collection<Book> getAll();
    void remove(Book book);
    void save(Book book);
}
