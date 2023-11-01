package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Autor;
import com.example.ProyectoLibreria.servicios.AutorServicioImpl;
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

@WebMvcTest(AutorControlador.class)
class AutorControladorTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AutorServicioImpl autorServicio;

    @Test
    void listarAutoresTest() throws Exception {
        Autor autor1 = Mockito.mock(Autor.class);
        Autor autor2 = Mockito.mock(Autor.class);
        List<Autor> autores = new ArrayList<>();
        autores.add(autor1);
        autores.add(autor2);

        Mockito.when(autorServicio.listarAutores()).thenReturn(autores);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/autores/mostrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()
                );
    }

    @Test
    void crearAutoresTest() throws Exception {
        Autor autor = Mockito.mock(Autor.class);

        Mockito.when(autorServicio.crearAutor(autor)).thenReturn("Autor creado y guardado con exito!");

        mockMvc.perform(MockMvcRequestBuilders.post("/autores/guardar")
                        .content("{\"nombre\":\"Aaron\"}").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void modificarAutoresTest() throws Exception {
        Autor autor = Mockito.mock(Autor.class);
        autor.setNombre("Aaron");
        autor.setAlta(true);
        autor.setId(1L);

        Mockito.when(autorServicio.modificarAutor(1L, autor)).thenReturn("Autor modificado con éxito!");

        mockMvc.perform(MockMvcRequestBuilders.put("/autores/actualizar/1")
                        .content("{\"nombre\":\"Exequiel\"}").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @Test
    void darDeBajaAutoresTest() throws Exception{
        Autor autor = Mockito.mock(Autor.class);
        autor.setNombre("Aaron");
        autor.setAlta(true);
        autor.setId(1L);

        Mockito.when(autorServicio.darDeBajaAutor(1L)).thenReturn("El autor se ha dado de baja.");

        mockMvc.perform(MockMvcRequestBuilders.put("/autores/baja/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }
}