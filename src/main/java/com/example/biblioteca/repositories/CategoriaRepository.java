package com.example.biblioteca.repositories;

import com.example.biblioteca.models.Categoria;
import com.example.biblioteca.repositories.CrudRepository.CategoriaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAll() {
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getCategoria(Long id){
        return categoriaCrudRepository.findById(id);
    }

    public Categoria save(Categoria ct){
        return categoriaCrudRepository.save(ct);
    }

    public void delete(Categoria ct){
        categoriaCrudRepository.delete(ct);
    }
}
