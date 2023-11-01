package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Libro;

import java.util.List;

public interface LibroServicio {
    List<Libro> listarLibros();
    String crearLibro(Libro libro);
    String modificarLibro(Long id, Libro libro);
    String darDeBajaLibro(Long id);
}
