package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Editorial;

import java.util.List;

public interface EditorialDAO {
    void guardar(Editorial editorial);

    void actualizar(Editorial editorial);

    Editorial buscarPorId(Long id);

    List<Editorial> buscarTodos();

    void darDeBaja(Long id);
}
