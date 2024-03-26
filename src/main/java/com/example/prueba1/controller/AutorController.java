package com.example.prueba1.controller;

import com.example.prueba1.entity.Autor;
import com.example.prueba1.repository.AutorRepository;
import com.example.prueba1.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Year;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/autores")
public class AutorController {
    private AutorRepository autorRepository;
    private AutorService autorService;

    //CREAMOS NUEVO AUTOR
    @PostMapping
    public Autor save(@RequestBody Autor autor){
        Autor autorSaved = autorRepository.save(autor);
        return autorSaved;
    }

    //BUSCAR POR ID //REVISAR
    @GetMapping("/{id}")
    public Autor getById(@PathVariable UUID id){
         Autor autorFound = autorRepository.getById(id);
        return autorFound;
    }
    //BUSCAR TODOS
    @GetMapping
    public List<Autor> getAll(){
        List<Autor> autores = autorRepository.findAll();
        return autores;
    }
    //ACTUALIZAR POR ID
    @PutMapping("/{id}")
    public Autor update(@PathVariable UUID id, @RequestBody Autor autor){
        Autor autorFound = autorRepository.findById(id).get();
        autorFound.setNombre(autor.getNombre());
        autorFound.setPaisOrigen(autor.getPaisOrigen());
        autorFound.setSexo(autor.getSexo());
        autorFound.setAnioNacimiento(autor.getAnioNacimiento());
        autorFound.setAnioDefuncion(autor.getAnioDefuncion());

        return autorRepository.save(autorFound);
    }
    //ELIMINAR POR ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        autorRepository.deleteById(id);
    }
    //BUSCAR AUTOR POR NOMBRE
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Autor> getByNombre(@PathVariable String nombre){
        Autor autorFound = autorService.getByNombre(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(autorFound);
    }
    @GetMapping("/anioNacimiento/{anioNacimiento}")
    public ResponseEntity<Autor> getByAnioNacimiento(@PathVariable Date anioNacimiento){
        Autor dateFound = autorService.getByAnioNacimiento(anioNacimiento);
        return ResponseEntity.status(HttpStatus.OK).body(dateFound);
    }
}
