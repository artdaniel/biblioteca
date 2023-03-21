package com.example.biblioteca.repositories;

import com.example.biblioteca.models.Libro;
import com.example.biblioteca.repositories.CrudRepository.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository {

    @Autowired
    private LibroCrudRepository libroCrudRepository;

    public List<Libro> getAll() {
        return (List<Libro>) libroCrudRepository.findAll();
    }

    public Optional<Libro> getLibro(Long id){
        return libroCrudRepository.findById(id);
    }

    public Libro save(Libro libro){
        return libroCrudRepository.save(libro);
    }

    public void delete(Libro libro){
        libroCrudRepository.delete(libro);
    }

}
