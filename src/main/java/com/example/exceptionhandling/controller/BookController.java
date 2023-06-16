package com.example.exceptionhandling.controller;


import com.example.exceptionhandling.entity.Book;
import com.example.exceptionhandling.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById( @PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping("/book/titre/{titre}")
    public ResponseEntity<Book> getBookByTitre( @PathVariable("titre") String  titre){
        return new ResponseEntity<>(bookService.getBookByTitre(titre), HttpStatus.OK);
    }



    @GetMapping("/book/auteur/{auteur}")
    public ResponseEntity<Book> getBookByAuteur( @PathVariable("auteur") String  auteur){
        return new ResponseEntity<>(bookService.getBookByAuteur(auteur), HttpStatus.OK);
    }

    @GetMapping("/book/titre/multiple/{titre}")
    public ResponseEntity<List<Book>> getBookByTitreContains( @PathVariable("titre") String  titre){
        return new ResponseEntity<>(bookService.getBookByTitreContains(titre), HttpStatus.OK);

    }

    @GetMapping("/book/auteur/multiple/{auteur}")
    public ResponseEntity<List<Book>> getBookByAuteurContains( @PathVariable("auteur") String  auteur){
        return new ResponseEntity<>(bookService.getBookByAuteurContains(auteur), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
        return new ResponseEntity<>(bookService.saveBook(book), CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody @Valid Book book) throws Exception {
        return new ResponseEntity<>(bookService.updateBook(id,book), CREATED);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook( @PathVariable("id") Long id){
        bookService.deleteBook(id);
    }

}
