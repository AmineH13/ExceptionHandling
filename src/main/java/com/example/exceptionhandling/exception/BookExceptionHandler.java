package com.example.exceptionhandling.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> bookExceptionHandler(MethodArgumentNotValidException exception){
        Map<String,String> erreurs = new HashMap<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(erreur->erreurs.put(erreur.getField(),erreur.getDefaultMessage()));
        return erreurs;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundException.class)
    public  Map<String,String> bookNotFound(BookNotFoundException exception)
    {
        Map<String,String> erreur = new HashMap<>();
        erreur.put("erreur : ",exception.getMessage());
        return erreur;
    }
}
