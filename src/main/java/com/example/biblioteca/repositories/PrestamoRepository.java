package com.example.biblioteca.repositories;

import com.example.biblioteca.models.Prestamo;
import com.example.biblioteca.repositories.CrudRepository.PrestamoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PrestamoRepository {

    @Autowired
    private PrestamoCrudRepository prestamoCrudRepository;

    public List<Prestamo> getAll() {
        return (List<Prestamo>) prestamoCrudRepository.findAll();
    }

    public Optional<Prestamo> getPrestamo(long id) { return prestamoCrudRepository.findById(id); }

    public Prestamo save(Prestamo prestamo) {
        return prestamoCrudRepository.save(prestamo);
    }

    public void delete(Prestamo prestamo) {
        prestamoCrudRepository.delete(prestamo);
    }


}
