package com.example.prueba1.repository;

import com.example.prueba1.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.Year;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
    //@Query(value = "SELECT * FROM autores WHERE nombre=?1",nativeQuery = true)
    //Autor findRoleByName(String name);
    Optional <Autor> findByNombre(String nombre);
    Optional <Autor> findByAnioNacimiento(Date anioNacimiento);
}
