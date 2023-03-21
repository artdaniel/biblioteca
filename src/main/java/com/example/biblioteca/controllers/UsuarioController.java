package com.example.biblioteca.controllers;


import com.example.biblioteca.models.Usuario;
import com.example.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Usuario")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id){
        return usuarioService.getUsuario(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){

        return usuarioService.save(usuario);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario)
    {return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int usuarioId) {
        return usuarioService.delete(usuarioId);
    }

}
