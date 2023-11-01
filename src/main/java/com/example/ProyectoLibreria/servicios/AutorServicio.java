package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Autor;

import java.util.List;

public interface AutorServicio {
    List<Autor> listarAutores();
    String crearAutor(Autor autor);
    String modificarAutor(Long id, Autor autor);
    String darDeBajaAutor(Long id);
}
