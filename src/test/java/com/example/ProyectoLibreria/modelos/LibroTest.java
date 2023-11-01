package com.example.ProyectoLibreria.modelos;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
    Set<Autor> autores = new HashSet<>();
    Editorial editorial = new Editorial();
    private Libro libro = new Libro(1L, 123456789L, "titulo", 2023, 100, 20, 80, true, autores, editorial);

    @Test
    void getIdTest() {
        assertEquals(1L, libro.getId());
    }

    @Test
    void getIsbnTest() {
        assertEquals(123456789L, libro.getIsbn());
    }

    @Test
    void getTituloTest() {
        assertEquals("titulo", libro.getTitulo());
    }

    @Test
    void getAnioTest() {
        assertEquals(2023, libro.getAnio());
    }

    @Test
    void getEjemplaresTest() {
        assertEquals(100, libro.getEjemplares());
    }

    @Test
    void getEjemplaresPrestadosTest() {
        assertEquals(20, libro.getEjemplaresPrestados());
    }

    @Test
    void getEjemplaresRestantesTest() {
        assertEquals(80, libro.getEjemplaresRestantes());
    }

    @Test
    void getAltaTest() {
        assertEquals(true, libro.getAlta());
    }

    @Test
    void getAutoresTest() {
        assertEquals(autores, libro.getAutores());
    }

    @Test
    void getEditorialTest() {
        assertEquals(editorial, libro.getEditorial());
    }

    @Test
    void setIdTest() {
        libro.setId(2L);
        assertEquals(2L, libro.getId());
    }

    @Test
    void setIsbnTest() {
        libro.setIsbn(987654321L);
        assertEquals(987654321L, libro.getIsbn());
    }

    @Test
    void setTituloTest() {
        libro.setTitulo("titulo 2");
        assertEquals("titulo 2", libro.getTitulo());
    }

    @Test
    void setAnioTest() {
        libro.setAnio(2024);
        assertEquals(2024, libro.getAnio());
    }

    @Test
    void setEjemplaresTest() {
        libro.setEjemplares(200);
        assertEquals(200, libro.getEjemplares());
    }

    @Test
    void setEjemplaresPrestadosTest() {
        libro.setEjemplaresPrestados(120);
        assertEquals(120, libro.getEjemplaresPrestados());
    }

    @Test
    void setEjemplaresRestantesTest() {
        libro.setEjemplaresRestantes(80);
        assertEquals(80, libro.getEjemplaresRestantes());
    }

    @Test
    void setAltaTest() {
        libro.setAlta(false);
        assertEquals(false, libro.getAlta());
    }

    @Test
    void setAutoresTest() {
        Set<Autor> nuevosAutores = new HashSet<>();
        Autor autor1 = new Autor();
        nuevosAutores.add(autor1);

        libro.setAutores(nuevosAutores);
        assertEquals(nuevosAutores, libro.getAutores());
    }

    @Test
    void setEditorialTest() {
        Editorial editorial2 = new Editorial();
        libro.setEditorial(editorial2);
        assertEquals(editorial2, libro.getEditorial());
    }
}