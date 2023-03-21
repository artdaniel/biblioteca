package com.example.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private String editorial;

    private String isbn;

    private Integer cantidadDisp;

    private Integer cantidadPrest;

    private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCantidadDisp() {
        return cantidadDisp;
    }

    public void setCantidadDisp(Integer cantidadDisp) {
        this.cantidadDisp = cantidadDisp;
    }

    public Integer getCantidadPrest() {
        return cantidadPrest;
    }

    public void setCantidadPrest(Integer cantidadPrest) {
        this.cantidadPrest = cantidadPrest;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}