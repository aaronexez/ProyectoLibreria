package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Libro;
import com.example.ProyectoLibreria.servicios.LibroServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroControlador {

    private final LibroServicio libroServicio;

    @GetMapping("/mostrar")
    List<Libro> listarLibros() {
        return libroServicio.listarLibros();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    String crearLibro(@RequestBody Libro libro) {
        return libroServicio.crearLibro(libro);
    }

    @PutMapping("/actualizar/{id}")
    String modificarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroServicio.modificarLibro(id, libro);
    }

    @PutMapping("/baja/{id}")
    String darDeBajaLibro(@PathVariable Long id) {
        return libroServicio.darDeBajaLibro(id);
    }


}
