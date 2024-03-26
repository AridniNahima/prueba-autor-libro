package com.example.prueba1.controller;

import com.example.prueba1.entity.Libro;
import com.example.prueba1.repository.LibroRepository;
import com.example.prueba1.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/libros")
public class LibroController {
    private LibroRepository libroRepository;
    private LibroService libroService;

    //CREAMOS NUEVO LIBRO
    @PostMapping
    public Libro save(@RequestBody Libro libro){
        Libro libroSaved = libroRepository.save(libro);
        return libroSaved;
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public Libro getById(@PathVariable UUID id){
        Libro libroFound = libroRepository.getById(id);
        return libroFound;
    }
    //BUSCAR TODOS
    @GetMapping
    public List<Libro> getAll(){
        List<Libro> libroes = libroRepository.findAll();
        return libroes;
    }
    //ACTUALIZAR POR ID
    @PutMapping("/{id}")
    public Libro update(@PathVariable UUID id, @RequestBody Libro libro){
        Libro libroFound = libroRepository.findById(id).get();
        libroFound.setTitulo(libro.getTitulo());
        libroFound.setAnioPublicacion(libro.getAnioPublicacion());
        return libroRepository.save(libroFound);
    }
    //ELIMINAR POR ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        libroRepository.deleteById(id);
    }
    //BUSCAR POR AÑO DE PUBLICACION
    @GetMapping("anioPublicacion/{anioPublicacion}")
    public ResponseEntity<Libro> getByanioPublicacion(@PathVariable Year anioPublicacion){
        Libro yearFound = libroService.getByAnioPublicacion(anioPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body(yearFound);
    }

}
