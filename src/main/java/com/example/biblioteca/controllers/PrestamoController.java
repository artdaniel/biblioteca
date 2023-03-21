package com.example.biblioteca.controllers;

import com.example.biblioteca.models.Prestamo;
import com.example.biblioteca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Prestamo")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/all")
    public List<Prestamo> getAll() {
        return prestamoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Prestamo> getReservation(@PathVariable("id") int id){
        return prestamoService.getPrestamo(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Prestamo save(@RequestBody Prestamo prestamo){
        return prestamoService.save(prestamo);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Prestamo update(@RequestBody Prestamo prestamo) {
        return prestamoService.update(prestamo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int prestamoId) {
        return prestamoService.delete(prestamoId);
    }

}
