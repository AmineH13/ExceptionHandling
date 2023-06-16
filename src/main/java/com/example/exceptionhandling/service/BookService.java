package com.example.exceptionhandling.service;

import com.example.exceptionhandling.entity.Book;

import java.util.List;

public interface BookService {
    public Book saveBook(Book book);
    public List<Book> getBooks();
    public Book getBookById(Long id) throws Exception;
    public Book getBookByTitre(String titre);
    public Book getBookByAuteur(String auteur);

    public List<Book> getBookByTitreContains(String titre);
    public List<Book> getBookByAuteurContains(String auteur);

    public Book updateBook(Long id, Book book) throws Exception;
    public boolean deleteBook(Long id);
}


