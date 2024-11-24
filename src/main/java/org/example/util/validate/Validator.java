package org.example.util.validate;

public interface Validator<T> {
    T validate(String input);
}
