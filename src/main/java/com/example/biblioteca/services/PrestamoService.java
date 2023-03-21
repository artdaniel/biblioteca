package com.example.biblioteca.services;

import com.example.biblioteca.models.Prestamo;
import com.example.biblioteca.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> getAll() {
        return prestamoRepository.getAll();
    }

    public Optional<Prestamo> getPrestamo(int id) {
        return prestamoRepository.getPrestamo(id);
    }

    public Prestamo save(Prestamo prestamo) {
        if (prestamo.getId() == null) {
            return prestamoRepository.save(prestamo);
        } else {
            Optional<Prestamo> messageEncontrado = prestamoRepository.getPrestamo(prestamo.getId());
            if (messageEncontrado.isPresent()) {
                return prestamo;
            } else {
                return prestamoRepository.save(prestamo);
            }
        }
    }
    public Prestamo update(Prestamo prestamo) {
        if (prestamo.getId() != null) {
            Optional<Prestamo> prestamoEncontrado = prestamoRepository.getPrestamo(prestamo.getId());
            if (!prestamoEncontrado.isPresent()) {
                if (prestamo.getFechaPrestamo() != null) {
                    prestamoEncontrado.get().setFechaPrestamo(prestamo.getFechaPrestamo());
                }
                if (prestamo.getFechaDevolucion() != null) {
                    prestamoEncontrado.get().setFechaDevolucion(prestamo.getFechaDevolucion());
                }
                if (prestamo.getEstado() != null) {
                    prestamoEncontrado.get().setEstado(prestamo.getEstado());
                }
                return prestamoRepository.save(prestamoEncontrado.get());
            }
        }
        return prestamo;
    }

    public boolean delete(int id){
        Boolean respuesta = getPrestamo(id).map(elemento ->{
            prestamoRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }


}
