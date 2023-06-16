package com.example.exceptionhandling.repository;
import com.example.exceptionhandling.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitre(String titre);
    Book findByAuteur(String auteur);

}

