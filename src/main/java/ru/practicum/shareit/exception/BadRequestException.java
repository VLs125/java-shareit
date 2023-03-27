package ru.practicum.shareit.exception;

public class BadRequestException extends RuntimeException {
    private final String text;

    public BadRequestException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
