package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Editorial;
import com.example.ProyectoLibreria.repositorios.EditorialDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EditorialServicioImplTest {
    @InjectMocks
    private EditorialServicioImpl editorialServicio;
    @Mock
    private EditorialDAO editorialDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarEditorialesTest() {
        List<Editorial> editoriales = new ArrayList<>();
        Mockito.when(editorialDAO.buscarTodos()).thenReturn(editoriales);

        List<Editorial> result = editorialServicio.listarEditoriales();

        assertEquals(editoriales, result);
    }

    @Test
    void crearEditorialTest() {
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");

        Mockito.doNothing().when(editorialDAO).guardar(editorial);

        String mensaje = editorialServicio.crearEditorial(editorial);

        assertEquals("Editorial creada y guardada con exito!", mensaje);
    }

    @Test
    void modificarEditorialTest() {
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorial.setId(1L);

        Mockito.when(editorialDAO.buscarPorId(editorial.getId())).thenReturn(editorial);

        editorial.setNombre("Pepsi");
        String mensaje = editorialServicio.modificarEditorial(editorial.getId(), editorial);

        assertEquals("Editorial actualizada con exito!", mensaje);

        String mensaje2 = editorialServicio.modificarEditorial(2L, editorial);

        assertEquals("No existe una editorial en el ID dado, actualización no realizada.", mensaje2);
    }

    @Test
    void darDeBajaEditorialTest() {
        Editorial editorial = new Editorial();
        editorial.setNombre("Manaos");
        editorial.setAlta(true);
        editorial.setId(1L);

        Mockito.when(editorialDAO.buscarPorId(editorial.getId())).thenReturn(editorial);

        String mensaje = editorialServicio.darDeBajaEditorial(editorial.getId());

        assertEquals("La editorial se ha dado de baja.", mensaje);

        String mensaje2 = editorialServicio.darDeBajaEditorial(2L);

        assertEquals("No existe una editorial en el ID dado, no se pudo dar de baja.", mensaje2);
    }
}