package com.example.prueba1.service;

import com.example.prueba1.entity.Autor;
import com.example.prueba1.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Year;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class AutorServiceImpl implements AutorService{

    private AutorRepository autorRepository;

    @Override
    public Autor getById(UUID id) {
        Autor autor = autorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("AUTOR NO ENCONTRADO"));
        return autor;
    }

    @Override
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getByNombre(String nombre) {
        return autorRepository.findByNombre(nombre).orElseThrow(()->new EntityNotFoundException("AUTOR NO ENCONTRADO"));
    }

    @Override
    public Autor getByAnioNacimiento(Date anioNacimiento) {
        return autorRepository.findByAnioNacimiento(anioNacimiento).orElseThrow(()->new EntityNotFoundException("FECHA NO ENCONTRADA"));
    }
}
