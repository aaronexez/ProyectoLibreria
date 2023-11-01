package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Libro;
import com.example.ProyectoLibreria.repositorios.LibroDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibroServicioImplTest {
    @InjectMocks
    private LibroServicioImpl libroServicio;
    @Mock
    private LibroDAO libroDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarLibrosTest() {
        List<Libro> libros = new ArrayList<>();
        Mockito.when(libroDAO.buscarTodos()).thenReturn(libros);

        List<Libro> result = libroServicio.listarLibros();

        assertEquals(libros, result);
    }

    @Test
    void crearLibroTest() {
        Libro libro = new Libro();
        libro.setTitulo("titulo");

        Mockito.doNothing().when(libroDAO).guardar(libro);

        String mensaje = libroServicio.crearLibro(libro);

        assertEquals("Libro creado y guardado con exito!", mensaje);
    }

    @Test
    void modificarLibroTest() {
        Libro libro = new Libro();
        libro.setTitulo("titulo");
        libro.setId(1L);

        Mockito.when(libroDAO.buscarPorId(libro.getId())).thenReturn(libro);

        libro.setTitulo("titulo modificado");
        String mensaje = libroServicio.modificarLibro(libro.getId(), libro);

        assertEquals("Libro actualizado con exito!", mensaje);

        String mensaje2 = libroServicio.modificarLibro(2L, libro);

        assertEquals("No existe un libro en el ID dado, actualización no realizada.", mensaje2);
    }

    @Test
    void darDeBajaLibroTest() {
        Libro libro = new Libro();
        libro.setTitulo("titulo");
        libro.setAlta(true);
        libro.setId(1L);

        Mockito.when(libroDAO.buscarPorId(libro.getId())).thenReturn(libro);

        String mensaje = libroServicio.darDeBajaLibro(libro.getId());

        assertEquals("El libro se ha dado de baja.", mensaje);

        String mensaje2 = libroServicio.darDeBajaLibro(2L);

        assertEquals("No existe un libro en el ID dado, no se pudo dar de baja.", mensaje2);
    }
}