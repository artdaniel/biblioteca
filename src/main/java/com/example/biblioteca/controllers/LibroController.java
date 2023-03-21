package com.example.biblioteca.controllers;

import com.example.biblioteca.models.Libro;
import com.example.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Libro")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/all")
    public List<Libro> getAll(){
        return libroService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable("id") long id){
        return libroService.getLibro(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro save(@RequestBody Libro libro){
        return libroService.save(libro);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro update(@RequestBody Libro libro) {
        return libroService.update(libro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") long libroId) {
        return libroService.delete(libroId);
    }
}
