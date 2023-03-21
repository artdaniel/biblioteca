package com.example.biblioteca.repositories.CrudRepository;

import com.example.biblioteca.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository <Usuario,Long> {
}
