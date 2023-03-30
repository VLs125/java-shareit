package ru.practicum.shareit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse entityIsAlreadyExist(AlreadyExists exception) {

        return new ErrorResponse(exception.getMessage(), "Объект уже создан");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse entityIsNotExist(NotFoundException exception) {

        return new ErrorResponse(exception.getMessage(), "Объект не найден");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse commonValidation(MethodArgumentNotValidException e) {
        List<FieldError> items = e.getBindingResult().getFieldErrors();
        String message = items.stream()
                .map(FieldError::getField)
                .findFirst().get() + " - "
                + items.stream()
                .map(FieldError::getDefaultMessage)
                .findFirst().get();

        return new ErrorResponse(message, "Ошибка валидации");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherExceptions(final Throwable e) {

        return new ErrorResponse(e.getMessage(), "Неизвестная ошибка");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIncorrectParameterException(final BadRequestException e) {

        return new ErrorResponse(e.getMessage(), "Некорректный параметр - " + e.getText());
    }
}
