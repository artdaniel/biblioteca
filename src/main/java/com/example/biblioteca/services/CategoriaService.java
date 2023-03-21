package com.example.biblioteca.services;

import com.example.biblioteca.models.Categoria;
import com.example.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoryRepository;

    public List<Categoria> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Categoria> getCategoria(long id) {
        return categoryRepository.getCategoria(id);
    }

    public Categoria save(Categoria category) {
        if (category.getIdCategoria() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Categoria> categoryEncontrado = getCategoria(category.getIdCategoria());
            if (!categoryEncontrado.isPresent()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Categoria update(Categoria category) {
        if (category.getIdCategoria() != null) {
            Optional<Categoria> categoryEncontrado = getCategoria(category.getIdCategoria());
            if (categoryEncontrado.isPresent()) {
                if (category.getDescripcion() != null) {
                    categoryEncontrado.get().setDescripcion(category.getDescripcion());
                }
                if (category.getNombre() != null) {
                    categoryEncontrado.get().setNombre(category.getNombre());
                }
                return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }

    public boolean delete(int id){
        Boolean respuesta = getCategoria(id).map(elemento ->{
            categoryRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
