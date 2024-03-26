package com.example.prueba1.service;

import com.example.prueba1.entity.Libro;
import com.example.prueba1.repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {
    private LibroRepository libroRepository;

    @Override
    public Libro getById(UUID id) {
        Libro libro= libroRepository.findById(id).orElseThrow(()->new EntityNotFoundException("LIBRO NO ENCONTRADO"));
        return libro;
    }

    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro getByAnioPublicacion(Year anioPublicacion) {
        return libroRepository.findByAnioPublicacion(anioPublicacion).orElseThrow(()-> new EntityNotFoundException("AÑO DE PUBLICACION NO ENCONTRADA"));
    }
}
