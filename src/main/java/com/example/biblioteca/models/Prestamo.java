package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="prestamo")
public class Prestamo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPrestamo;

       private Date fechaPrestamo;

        private Date fechaDevolucion;

        private String estado = "creado";

        @ManyToOne
        @JoinColumn(name = "usuarioId")
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(name = "libroId")
        private Libro libro;



        // getters y setters


        public Long getId() {
                return idPrestamo;
        }

        public void setId(Long id) {
                this.idPrestamo = id;
        }

        public Usuario getUsuario() {
                return usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        public Libro getLibro() {
                return libro;
        }

        public void setLibro(Libro libro) {
                this.libro = libro;
        }

        public Date getFechaPrestamo() {
                return fechaPrestamo;
        }

        public void setFechaPrestamo(Date fechaPrestamo) {
                this.fechaPrestamo = fechaPrestamo;
        }

        public Date getFechaDevolucion() {
                return fechaDevolucion;
        }

        public void setFechaDevolucion(Date fechaDevolucion) {
                this.fechaDevolucion = fechaDevolucion;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public Long getIdPrestamo() {
                return idPrestamo;
        }

        public void setIdPrestamo(Long idPrestamo) {
                this.idPrestamo = idPrestamo;
        }

}
