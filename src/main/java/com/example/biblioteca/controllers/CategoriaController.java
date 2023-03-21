package com.example.biblioteca.controllers;

import com.example.biblioteca.models.Categoria;
import com.example.biblioteca.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public List<Categoria> getAll() {
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategory(@PathVariable("id") int id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoriaService.delete(categoriaId);
    }
}
