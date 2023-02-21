package com.example.homework6februar.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String entity) {
        super("Ошибка валидации" + entity);
    }
}
