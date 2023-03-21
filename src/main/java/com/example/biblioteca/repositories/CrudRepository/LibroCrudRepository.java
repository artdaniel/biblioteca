package com.example.biblioteca.repositories.CrudRepository;

import com.example.biblioteca.models.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroCrudRepository extends CrudRepository<Libro, Long> {

}
