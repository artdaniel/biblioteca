package com.example.biblioteca.services;


import com.example.biblioteca.models.Usuario;
import com.example.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.getAll();
    }
    public Optional<Usuario> getUsuario(long id){ return usuarioRepository.getUsuario(id);  }
    public Usuario save(Usuario usuario){
        if(usuario.getId()==null){
            return usuarioRepository.save(usuario);
        }else{
            Optional<Usuario> usuarioEncontrado = getUsuario(usuario.getId());
            if(usuarioEncontrado.isPresent()){
                return usuarioRepository.save(usuario);
            }else{
                return usuario;
            }
        }
    }

    public Usuario update(Usuario usuario){
        if(usuario.getId()!= null){
            Optional<Usuario> usuarioEncontrado = getUsuario(usuario.getId());
            if(usuarioEncontrado.isPresent()){
                if(usuario.getNombre()!=null){
                    usuarioEncontrado.get().setNombre(usuario.getNombre());
                }

                return usuarioRepository.save(usuarioEncontrado.get());
            }
        }
        return usuario;
    }

    public boolean delete(int id){
        Boolean respuesta = getUsuario(id).map(elemento ->{
            usuarioRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
