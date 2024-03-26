package com.example.prueba1.repository;

import com.example.prueba1.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Optional;
import java.util.UUID;

public interface LibroRepository extends JpaRepository<Libro, UUID> {
    Optional <Libro> findByAnioPublicacion(Year anioPublicacion);
}
