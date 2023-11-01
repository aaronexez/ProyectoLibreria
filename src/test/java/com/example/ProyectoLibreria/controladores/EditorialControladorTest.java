package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Editorial;
import com.example.ProyectoLibreria.servicios.EditorialServicioImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EditorialControlador.class)
class EditorialControladorTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EditorialServicioImpl editorialServicio;

    @Test
    void listarEditorialesTest() throws Exception {
        Editorial editorial1 = Mockito.mock(Editorial.class);
        Editorial editorial2 = Mockito.mock(Editorial.class);
        List<Editorial> editoriales = new ArrayList<>();
        editoriales.add(editorial1);
        editoriales.add(editorial2);

        Mockito.when(editorialServicio.listarEditoriales()).thenReturn(editoriales);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/editoriales/mostrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()
                );
    }

    @Test
    void crearEditorialesTest() throws Exception {
        Editorial editorial = Mockito.mock(Editorial.class);

        Mockito.when(editorialServicio.crearEditorial(editorial)).thenReturn("Editorial creada y guardada con exito!");

        mockMvc.perform(MockMvcRequestBuilders.post("/editoriales/guardar")
                        .content("{\"nombre\":\"Manaos\"}").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void modificarEditorialesTest() throws Exception {
        Editorial editorial = Mockito.mock(Editorial.class);
        editorial.setNombre("Manaos");
        editorial.setAlta(true);
        editorial.setId(1L);

        Mockito.when(editorialServicio.modificarEditorial(1L, editorial)).thenReturn("Editorial modificada con éxito!");

        mockMvc.perform(MockMvcRequestBuilders.put("/editoriales/actualizar/1")
                        .content("{\"nombre\":\"Fanta\"}").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @Test
    void darDeBajaEditorialesTest() throws Exception {
        Editorial editorial = Mockito.mock(Editorial.class);
        editorial.setNombre("Manaos");
        editorial.setAlta(true);
        editorial.setId(1L);

        Mockito.when(editorialServicio.darDeBajaEditorial(1L)).thenReturn("La editorial se ha dado de baja.");

        mockMvc.perform(MockMvcRequestBuilders.put("/editoriales/baja/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }
}