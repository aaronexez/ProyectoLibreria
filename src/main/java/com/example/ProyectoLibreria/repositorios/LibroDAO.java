package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Libro;

import java.util.List;

public interface LibroDAO {
    void guardar(Libro libro);

    void actualizar(Libro libro);

    Libro buscarPorId(Long id);

    List<Libro> buscarTodos();

    void darDeBaja(Long id);
}
