package com.example.prueba1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Year;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue
    private UUID id;
    private String titulo;
    private Year anioPublicacion;
}
