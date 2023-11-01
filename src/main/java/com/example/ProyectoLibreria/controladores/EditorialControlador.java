package com.example.ProyectoLibreria.controladores;

import com.example.ProyectoLibreria.modelos.Editorial;
import com.example.ProyectoLibreria.servicios.EditorialServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
@RequiredArgsConstructor
public class EditorialControlador {

    private final EditorialServicio editorialServicio;

    @GetMapping("/mostrar")
    List<Editorial> listarEditoriales() {
        return editorialServicio.listarEditoriales();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    String crearEditorial(@RequestBody Editorial editorial) {
        return editorialServicio.crearEditorial(editorial);
    }

    @PutMapping("/actualizar/{id}")
    String modificarEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
        return editorialServicio.modificarEditorial(id, editorial);
    }

    @PutMapping("/baja/{id}")
    String darDeBajaEditorial(@PathVariable Long id) {
        return editorialServicio.darDeBajaEditorial(id);
    }
}
