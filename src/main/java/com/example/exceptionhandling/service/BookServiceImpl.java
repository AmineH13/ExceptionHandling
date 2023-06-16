package com.example.exceptionhandling.service;

import com.example.exceptionhandling.entity.Book;
import com.example.exceptionhandling.exception.BookNotFoundException;
import com.example.exceptionhandling.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service  @AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> getBooks() {

        return bookRepository.findAll().stream().toList();
    }

    @Override
    public Book getBookById(Long id) throws Exception {
        Optional<Book> book = bookRepository.findById(id);
            return book.orElseThrow(()->new BookNotFoundException("Book doesnt exist.."));
    }

    @Override
    public Book getBookByTitre(String titre) {
        Book book = bookRepository.findByTitre(titre);
        return book;
    }

    @Override
    public Book getBookByAuteur(String auteur) {
        Book book = bookRepository.findByAuteur(auteur);
        return book;
    }

    @Override
    public List<Book> getBookByTitreContains(String titre) {
        List<Book> books=new ArrayList<>();
        List<Book> books1= getBooks();
        for (Book book : books1)
        {
            if( book.getTitre().toLowerCase().contains(titre.toLowerCase()))
                books.add(book);
        }
        return books;
    }

    @Override
    public List<Book> getBookByAuteurContains(String auteur) {
        List<Book> books=new ArrayList<>();
        List<Book> books1= getBooks();
        for (Book book : books1)
        {    if( book.getAuteur().toLowerCase().contains(auteur.toLowerCase()))
                books.add(book);
        }
        return books;
    }

    @Override
    public Book updateBook(Long id,Book book) throws Exception {
        Book book1=getBookById(id);
        if(!"".equalsIgnoreCase(book.getTitre()))
            book1.setTitre(book.getTitre());
        if(!"".equalsIgnoreCase(book.getAuteur()))
            book1.setAuteur(book.getAuteur());

        return bookRepository.save(book1);
    }
    @Override
    public boolean deleteBook(Long id) {
        try
        {   bookRepository.deleteById(id);
            return true;  }
        catch (Exception e)
        { return false; }
    }
}
