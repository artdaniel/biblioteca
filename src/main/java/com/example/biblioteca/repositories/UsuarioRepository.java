package com.example.biblioteca.repositories;

import com.example.biblioteca.models.Usuario;
import com.example.biblioteca.repositories.CrudRepository.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }
    public Optional<Usuario> getUsuario(long id){
        return usuarioCrudRepository.findById(id);
    }

    public Usuario save(Usuario us){
        return usuarioCrudRepository.save(us);
    }

    public void delete(Usuario us){
        usuarioCrudRepository.delete(us);
    }

}
