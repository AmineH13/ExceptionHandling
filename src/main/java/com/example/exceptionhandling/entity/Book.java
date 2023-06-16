package com.example.exceptionhandling.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire..")
    private String titre;
    @NotBlank(message = "L'auteur est obligatoire..")
    private String auteur;

    public Book(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }
}


