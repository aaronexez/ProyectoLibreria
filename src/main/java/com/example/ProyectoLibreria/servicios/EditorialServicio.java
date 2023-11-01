package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Editorial;

import java.util.List;

public interface EditorialServicio {
    List<Editorial> listarEditoriales();

    String crearEditorial(Editorial editorial);

    String modificarEditorial(Long id, Editorial editorial);

    String darDeBajaEditorial(Long id);
}
