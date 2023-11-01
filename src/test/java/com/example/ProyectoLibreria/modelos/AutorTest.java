package com.example.ProyectoLibreria.modelos;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {
    Set<Libro> libros = new HashSet<>();
    private Autor autor = new Autor(1L, "Aaron", true, libros);

    @Test
    void getIdTest() {
        assertEquals(1L, autor.getId());
    }

    @Test
    void getNombreTest() {
        assertEquals("Aaron", autor.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true, autor.getAlta());
    }

    @Test
    void getLibrosTest() {
        assertEquals(libros, autor.getLibros());
    }

    @Test
    void setIdTest() {
        autor.setId(2L);
        assertEquals(2L, autor.getId());
    }

    @Test
    void setNombreTest() {
        autor.setNombre("Exequiel");
        assertEquals("Exequiel", autor.getNombre());
    }

    @Test
    void setAltaTest() {
        autor.setAlta(false);
        assertEquals(false, autor.getAlta());
    }

    @Test
    void setLibrosTest() {
        Set<Libro> nuevosLibros = new HashSet<>();
        Libro libro1 = new Libro();
        nuevosLibros.add(libro1);

        autor.setLibros(nuevosLibros);
        assertEquals(nuevosLibros,autor.getLibros());
    }
}