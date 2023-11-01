package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Autor;
import com.example.ProyectoLibreria.servicios.AutorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorControlador {

    private final AutorServicio autorServicio;

    @GetMapping("/mostrar")
    List<Autor> listarAutores() {
        return autorServicio.listarAutores();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    String crearAutor(@RequestBody Autor autor) {
        return autorServicio.crearAutor(autor);
    }

    @PutMapping("/actualizar/{id}")
    String modificarAutor(@PathVariable Long id,@RequestBody Autor autor){
        return autorServicio.modificarAutor(id,autor);
    }

    @PutMapping("/baja/{id}")
    String darDeBajaAutor(@PathVariable Long id){
        return autorServicio.darDeBajaAutor(id);
    }
}
