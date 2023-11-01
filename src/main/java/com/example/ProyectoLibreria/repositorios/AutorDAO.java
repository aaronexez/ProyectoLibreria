package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Autor;

import java.util.List;

public interface AutorDAO {
    void guardar(Autor autor);

    void actualizar(Autor autor);

    Autor buscarPorId(Long id);

    List<Autor> buscarTodos();

    void darDeBaja(Long id);
}
