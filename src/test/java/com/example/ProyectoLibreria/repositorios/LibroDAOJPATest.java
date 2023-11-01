package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibroDAOJPATest {

    @Autowired
    private LibroDAOJPA libroDAO;

    @BeforeEach
    public void setUp() {
    }

    @Test
    @Transactional
    void guardarTest() {
        System.out.println("\n----Guardar Test----");
        Libro libro = new Libro();
        libro.setTitulo("prueba");
        libroDAO.guardar(libro);
        System.out.println("Libro ID: " + libro.getId());
        System.out.println("Libro titulo: " + libro.getTitulo());

        assertNotNull(libro.getId()); //verificando que el id se haya generado automaticamente

        Libro result = libroDAO.buscarPorId(libro.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result titulo: " + result.getTitulo());
        assertNotNull(result);
        assertEquals(libro.getTitulo(),result.getTitulo());
    }

    @Test
    @Transactional
    void actualizarTest() {
        System.out.println("\n----Actualizar Test----");
        Libro libro = new Libro();
        libro.setTitulo("prueba");
        libroDAO.guardar(libro);
        System.out.println("Libro ID: " + libro.getId());
        System.out.println("Libro titulo: " + libro.getTitulo());

        assertNotNull(libro.getId());

        libro.setTitulo("prueba actualizada");
        libroDAO.actualizar(libro);

        Libro result = libroDAO.buscarPorId(libro.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result titulo: " + result.getTitulo());
        assertNotNull(result);
        assertEquals("prueba actualizada", result.getTitulo());
    }

    @Test
    void buscarPorIdTest() {
        System.out.println("\n----Buscar por id Test----");
        Libro libro = new Libro();
        libro.setTitulo("prueba");
        libroDAO.guardar(libro);
        System.out.println("Libro ID: " + libro.getId());
        System.out.println("Libro titulo: " + libro.getTitulo());

        assertNotNull(libro.getId());

        Libro result = libroDAO.buscarPorId(libro.getId());
        System.out.println("Result ID (requerido): " + result.getId());
        assertNotNull(result);
        assertEquals(libro.getId(), result.getId());
    }

    @Test
    void buscarTodosTest() {
        System.out.println("\n----Buscar todos Test----");
        List<Libro> libros = new ArrayList<>();
        Libro libro1 = new Libro();
        libro1.setTitulo("prueba libro 1");
        libro1.setAlta(true);
        Libro libro2 = new Libro();
        libro2.setTitulo("prueba libro 2");
        libro2.setAlta(true);
        Libro libro3 = new Libro();
        libro3.setTitulo("prueba libro 3");
        libro3.setAlta(false);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libroDAO.guardar(libro1);
        libroDAO.guardar(libro2);
        libroDAO.guardar(libro3);
        System.out.println("Libro 1 alta: " + libro1.getAlta());
        System.out.println("Libro 2 alta: " + libro2.getAlta());
        System.out.println("Libro 3 alta: " + libro3.getAlta());

        assertNotNull(libro1.getId());
        assertNotNull(libro2.getId());
        assertNotNull(libro3.getId());

        List<Libro> result = libroDAO.buscarTodos();
        System.out.println("Cantidad de libros: " + libros.size());
        System.out.println("Cantidad de result (true): " + result.size());
        assertNotNull(result);
        assertEquals(libros.size() - 1, (result.size()));
    }

    @Test
    @Transactional
    void darDeBajaTest() {
        System.out.println("\n----Dar de baja Test----");
        Libro libro = new Libro();
        libro.setTitulo("prueba");
        libro.setAlta(true);
        libroDAO.guardar(libro);
        System.out.println("Libro ID: " + libro.getId());
        System.out.println("Libro titulo: " + libro.getTitulo());
        System.out.println("Libro alta: " + libro.getAlta());

        assertNotNull(libro.getId());
        assertTrue(libro.getAlta());

        libroDAO.darDeBaja(libro.getId());

        Libro result = libroDAO.buscarPorId(libro.getId());

        System.out.println("Result ID: " + result.getId());
        System.out.println("Result alta: " + result.getAlta());
        assertNotNull(result);
        assertFalse(result.getAlta());
    }
}