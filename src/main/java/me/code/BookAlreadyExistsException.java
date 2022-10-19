package me.code;

public class BookAlreadyExistsException extends Exception {

    private final Type type;

    public BookAlreadyExistsException(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        Name,
        ISBN
    }
}
