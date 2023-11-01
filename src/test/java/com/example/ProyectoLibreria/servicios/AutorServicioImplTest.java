package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Autor;
import com.example.ProyectoLibreria.repositorios.AutorDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutorServicioImplTest {
    @InjectMocks
    private AutorServicioImpl autorServicio;
    @Mock
    private AutorDAO autorDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarAutoresTest() {
        List<Autor> autores = new ArrayList<>();
        Mockito.when(autorDAO.buscarTodos()).thenReturn(autores);

        List<Autor> result = autorServicio.listarAutores();

        assertEquals(autores, result);
    }

    @Test
    void crearAutorTest() {
        Autor autor = new Autor();
        autor.setNombre("Aaron");

        Mockito.doNothing().when(autorDAO).guardar(autor);

        String mensaje = autorServicio.crearAutor(autor);

        assertEquals("Autor creado y guardado con exito!", mensaje);
    }

    @Test
    void modificarAutorTest() {
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autor.setId(1L);

        Mockito.when(autorDAO.buscarPorId(autor.getId())).thenReturn(autor);

        autor.setNombre("Exequiel");
        String mensaje = autorServicio.modificarAutor(autor.getId(), autor);

        assertEquals("Autor actualizado con exito!", mensaje);

        String mensaje2 = autorServicio.modificarAutor(2L, autor);

        assertEquals("No existe un autor en el ID dado, actualización no realizada.", mensaje2);
    }

    @Test
    void darDeBajaAutorTest() {
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autor.setAlta(true);
        autor.setId(1L);

        Mockito.when(autorDAO.buscarPorId(autor.getId())).thenReturn(autor);

        String mensaje = autorServicio.darDeBajaAutor(autor.getId());

        assertEquals("El autor se ha dado de baja.", mensaje);

        String mensaje2 = autorServicio.darDeBajaAutor(2L);

        assertEquals("No existe un autor en el ID dado, no se pudo dar de baja.", mensaje2);
    }
}