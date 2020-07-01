package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class) // <2>
    public String handlemethodArgumentNotValid(MethodArgumentNotValidException exception) { // <4>
        // TODO you can choose to return your custom object here, which will then get transformed to json/xml etc.
        return "Sorry, that was not quite right: " + exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class) // <3>
    public String handleConstraintViolation(ConstraintViolationException exception) { // <4>
        // TODO you can choose to return your custom object here, which will then get transformed to json/xml etc.
        return "Sorry, that was not quite right: " + exception.getMessage();
    }
}
