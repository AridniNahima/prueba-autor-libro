package com.example.prueba1.service;

import com.example.prueba1.entity.Autor;

import java.sql.Date;
import java.time.Year;
import java.util.List;
import java.util.UUID;

public interface AutorService {
    Autor getById(UUID id); //obtiene ID
    List<Autor> getAll();   //obtiene una lista de Autores
    Autor getByNombre(String nombre); //Obtener nombre
    Autor getByAnioNacimiento(Date anioNacimiento);
}
