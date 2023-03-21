package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="usuario")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUsuario;

        private String nombre;

        private String correo;

        private String telefono;

        @OneToMany(mappedBy = "usuario")
        @JsonIgnoreProperties("usuario")
        private List<Prestamo> prestamos;

        // getters y setters


        public Long getId() {
                return idUsuario;
        }

        public void setId(Long id) {
                this.idUsuario = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getCorreo() {
                return correo;
        }

        public void setCorreo(String correo) {
                this.correo = correo;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public List<Prestamo> getPrestamos() {
                return prestamos;
        }

        public void setPrestamos(List<Prestamo> prestamos) {
                this.prestamos = prestamos;
        }
}
