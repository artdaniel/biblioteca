package com.example.biblioteca.services;

import com.example.biblioteca.models.Libro;
import com.example.biblioteca.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

        @Autowired
        private LibroRepository libroRepository;

        public List<Libro> getAllBooks() {
            return (List<Libro>) libroRepository.getAll();
        }

        public Optional<Libro> getLibro(Long id){return libroRepository.getLibro(id);  }

        public Libro save(Libro libro){
            if(libro.getId() == null){
                return libroRepository.save(libro);
            } else{
                Optional<Libro> bookEncontrado = libroRepository.getLibro(libro.getId());
                if(bookEncontrado.isPresent()){
                    return libroRepository.save(libro);
                } else{
                    return libro;
                }
            }
        }
        public Libro update(Libro libro){
                return libro;
        }

        public boolean delete(long bookId){
            Boolean resultado = getLibro(bookId).map(libroPorEliminar ->{
                //Boolean resultado = getAdmin(Id).map(elemento ->{
                return true;
            }).orElse(false);
            return resultado;
        }

}
