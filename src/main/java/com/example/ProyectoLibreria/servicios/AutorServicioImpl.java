package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Autor;
import com.example.ProyectoLibreria.modelos.Libro;
import com.example.ProyectoLibreria.repositorios.AutorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServicioImpl implements AutorServicio {

    private final AutorDAO autorDAO;

    @Override
    public List<Autor> listarAutores() {
        return autorDAO.buscarTodos();
    }

    @Override
    public String crearAutor(Autor autor) {
        autorDAO.guardar(autor);
        return "Autor creado y guardado con exito!";
    }

    @Override
    public String modificarAutor(Long id, Autor autor) {
        Autor autorActual = autorDAO.buscarPorId(id);


        if (autorActual != null) {
            if (autor.getNombre() != null) {
                autorActual.setNombre(autor.getNombre());
            }
            if (autor.getAlta() != null) {
                autorActual.setAlta(autor.getAlta());
            }

            autorDAO.actualizar(autorActual);
            return "Autor actualizado con exito!";
        } else {
            return "No existe un autor en el ID dado, actualización no realizada.";
        }
    }

    @Override
    public String darDeBajaAutor(Long id) {
        Autor autor = autorDAO.buscarPorId(id);
        if (autor != null) {
            autorDAO.darDeBaja(id);
            return "El autor se ha dado de baja.";
        } else {
            return "No existe un autor en el ID dado, no se pudo dar de baja.";
        }
    }
}
