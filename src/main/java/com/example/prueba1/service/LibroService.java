package com.example.prueba1.service;

import com.example.prueba1.entity.Libro;
import org.springframework.stereotype.Service;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@Service
public interface LibroService {
    Libro getById(UUID id); // OBTIENE UN ID DE LIBRO

    List<Libro> getAll();   // OBTIENE UNA LISTA DE LIBROS

    Libro getByAnioPublicacion(Year anioPublicacion);



}
