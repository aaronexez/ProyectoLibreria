package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Libro;
import com.example.ProyectoLibreria.servicios.LibroServicioImpl;
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

@WebMvcTest(LibroControlador.class)
class LibroControladorTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibroServicioImpl libroServicio;

    @Test
    void listarLibrosTest() throws Exception {
        Libro libro1 = Mockito.mock(Libro.class);
        Libro libro2 = Mockito.mock(Libro.class);
        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);

        Mockito.when(libroServicio.listarLibros()).thenReturn(libros);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/libros/mostrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()
                );
    }

    @Test
    void crearLibroTest() throws Exception {
        Libro libro = Mockito.mock(Libro.class);

        Mockito.when(libroServicio.crearLibro(libro)).thenReturn("Libro creado y guardado con exito!");

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/guardar")
                .content("{\"titulo\":\"Java Intermedio\"}").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void modificarLibroTest() throws Exception {
        Libro libro = Mockito.mock(Libro.class);
        libro.setTitulo("Java Intermedio");
        libro.setAlta(true);
        libro.setId(1L);

        Mockito.when(libroServicio.modificarLibro(1L, libro)).thenReturn("Libro modificado con éxito!");

        mockMvc.perform(MockMvcRequestBuilders.put("/libros/actualizar/1")
                .content("{\"titulo\":\"Java Avanzado\"}").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @Test
    void darDeBajaLibroTest() throws Exception{
        Libro libro = Mockito.mock(Libro.class);
        libro.setTitulo("Java Intermedio");
        libro.setAlta(true);
        libro.setId(1L);

        Mockito.when(libroServicio.darDeBajaLibro(1L)).thenReturn("El libro se ha dado de baja.");

        mockMvc.perform(MockMvcRequestBuilders.put("/libros/baja/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }
}