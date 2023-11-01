package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AutorDAOJPATest {

    @Autowired
    private AutorDAOJPA autorDAO;

    @BeforeEach
    public void setUp() {
    }

    @Test
    @Transactional
    void guardarTest() {
        System.out.println("\n----Guardar Test----");
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autorDAO.guardar(autor);
        System.out.println("Autor ID: " + autor.getId());
        System.out.println("Autor nombre: " + autor.getNombre());

        assertNotNull(autor.getId()); //verificando el id generado

        Autor result = autorDAO.buscarPorId(autor.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result nombre: " + result.getNombre());
        assertNotNull(result);
        assertEquals(autor.getNombre(), result.getNombre());
    }

    @Test
    @Transactional
    void actualizarTest() {
        System.out.println("\n----Actualizar Test----");
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autorDAO.guardar(autor);
        System.out.println("Autor ID: " + autor.getId());
        System.out.println("Autor nombre: " + autor.getNombre());

        assertNotNull(autor.getId());

        autor.setNombre("Exequiel");
        autorDAO.actualizar(autor);

        Autor result = autorDAO.buscarPorId(autor.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result nombre: " + result.getNombre());
        assertNotNull(result);
        assertEquals("Exequiel", result.getNombre());
    }

    @Test
    void buscarPorIdTest() {
        System.out.println("\n----Buscar por id Test----");
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autorDAO.guardar(autor);
        System.out.println("Autor ID: " + autor.getId());
        System.out.println("Autor nombre: " + autor.getNombre());

        assertNotNull(autor.getId());

        Autor result = autorDAO.buscarPorId(autor.getId());
        System.out.println("Result ID (requerido): " + result.getId());
        assertNotNull(result);
        assertEquals(autor.getId(), result.getId());
    }

    @Test
    void buscarTodosTest() {
        System.out.println("\n----Buscar todos Test----");
        List<Autor> autores = new ArrayList<>();
        Autor autor1 = new Autor();
        autor1.setNombre("Aaron");
        autor1.setAlta(true);
        Autor autor2 = new Autor();
        autor2.setNombre("Fran");
        autor2.setAlta(true);
        Autor autor3 = new Autor();
        autor3.setNombre("Juan");
        autor3.setAlta(false);
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autorDAO.guardar(autor1);
        autorDAO.guardar(autor2);
        autorDAO.guardar(autor3);
        System.out.println("Autor 1 alta: " + autor1.getAlta());
        System.out.println("Autor 2 alta: " + autor2.getAlta());
        System.out.println("Autor 3 alta: " + autor3.getAlta());

        assertNotNull(autor1.getId());
        assertNotNull(autor2.getId());
        assertNotNull(autor3.getId());

        List<Autor> result = autorDAO.buscarTodos();
        System.out.println("Cantidad de autores: " + autores.size());
        System.out.println("Cantidad de result (true): " + result.size());
        assertNotNull(result);
        assertEquals(autores.size() - 1, (result.size()));
    }

    @Test
    @Transactional
    void darDeBajaTest() {
        System.out.println("\n----Dar de baja Test----");
        Autor autor = new Autor();
        autor.setNombre("Aaron");
        autor.setAlta(true);
        autorDAO.guardar(autor);
        System.out.println("Autor ID: " + autor.getId());
        System.out.println("Autor nombre: " + autor.getNombre());
        System.out.println("Autor alta: " + autor.getAlta());

        assertNotNull(autor.getId());
        assertTrue(autor.getAlta());

        autorDAO.darDeBaja(autor.getId());

        Autor result = autorDAO.buscarPorId(autor.getId());

        System.out.println("Result ID: " + result.getId());
        System.out.println("Result alta: " + result.getAlta());
        assertNotNull(result);
        assertFalse(result.getAlta());
    }
}