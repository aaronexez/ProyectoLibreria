package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Editorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EditorialDAOJPATest {

    @Autowired
    private EditorialDAOJPA editorialDAO;

    @BeforeEach
    public void setUp() {
    }

    @Test
    @Transactional
    void guardarTest() {
        System.out.println("\n----Guardar Test----");
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorialDAO.guardar(editorial);
        System.out.println("Editorial ID: " + editorial.getId());
        System.out.println("Editorial nombre: " + editorial.getNombre());

        assertNotNull(editorial.getId()); //verificando el id generado

        Editorial result = editorialDAO.buscarPorId(editorial.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result nombre: " + result.getNombre());
        assertNotNull(result);
        assertEquals(editorial.getNombre(), result.getNombre());
    }

    @Test
    @Transactional
    void actualizarTest() {
        System.out.println("\n----Actualizar Test----");
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorialDAO.guardar(editorial);
        System.out.println("Editorial ID: " + editorial.getId());
        System.out.println("Editorial nombre: " + editorial.getNombre());

        assertNotNull(editorial.getId());

        editorial.setNombre("Pepsi");
        editorialDAO.actualizar(editorial);

        Editorial result = editorialDAO.buscarPorId(editorial.getId());
        System.out.println("Result ID: " + result.getId());
        System.out.println("Result nombre: " + result.getNombre());
        assertNotNull(result);
        assertEquals("Pepsi", result.getNombre());
    }

    @Test
    void buscarPorIdTest() {
        System.out.println("\n----Buscar por id Test----");
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorialDAO.guardar(editorial);
        System.out.println("Editorial ID: " + editorial.getId());
        System.out.println("Editorial nombre: " + editorial.getNombre());

        assertNotNull(editorial.getId());

        Editorial result = editorialDAO.buscarPorId(editorial.getId());
        System.out.println("Result ID (requerido): " + result.getId());
        assertNotNull(result);
        assertEquals(editorial.getId(), result.getId());
    }

    @Test
    void buscarTodosTest() {
        System.out.println("\n----Buscar todos Test----");
        List<Editorial> editoriales = new ArrayList<>();
        Editorial editorial1 = new Editorial();
        editorial1.setNombre("Manaos");
        editorial1.setAlta(true);
        Editorial editorial2 = new Editorial();
        editorial2.setNombre("Fanta");
        editorial2.setAlta(true);
        Editorial editorial3 = new Editorial();
        editorial3.setNombre("Pepsi");
        editorial3.setAlta(false);
        editoriales.add(editorial1);
        editoriales.add(editorial2);
        editoriales.add(editorial3);
        editorialDAO.guardar(editorial1);
        editorialDAO.guardar(editorial2);
        editorialDAO.guardar(editorial3);
        System.out.println("Editorial 1 alta: " + editorial1.getAlta());
        System.out.println("Editorial 2 alta: " + editorial2.getAlta());
        System.out.println("Editorial 3 alta: " + editorial3.getAlta());

        assertNotNull(editorial1.getId());
        assertNotNull(editorial2.getId());
        assertNotNull(editorial3.getId());

        List<Editorial> result = editorialDAO.buscarTodos();
        System.out.println("Cantidad de editoriales: " + editoriales.size());
        System.out.println("Cantidad de result (true): " + result.size());
        assertNotNull(result);
        assertEquals(editoriales.size() - 1, result.size());
    }

    @Test
    @Transactional
    void darDeBajaTest() {
        System.out.println("\n----Dar de baja Test----");
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorial.setAlta(true);
        editorialDAO.guardar(editorial);
        System.out.println("Editorial ID: " + editorial.getId());
        System.out.println("Editorial nombre: " + editorial.getNombre());
        System.out.println("Editorial alta: " + editorial.getAlta());

        assertNotNull(editorial.getId());
        assertTrue(editorial.getAlta());

        editorialDAO.darDeBaja(editorial.getId());

        Editorial result = editorialDAO.buscarPorId(editorial.getId());

        System.out.println("Result ID: " + result.getId());
        System.out.println("Result alta: " + result.getAlta());
        assertNotNull(result);
        assertFalse(result.getAlta());
    }
}