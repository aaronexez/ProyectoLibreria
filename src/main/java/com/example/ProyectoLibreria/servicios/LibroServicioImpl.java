package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Libro;
import com.example.ProyectoLibreria.repositorios.LibroDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServicioImpl implements LibroServicio {

    private final LibroDAO libroDAO;

    @Override
    public List<Libro> listarLibros() {
        return libroDAO.buscarTodos();
    }

    @Override
    public String crearLibro(Libro libro) {
        libroDAO.guardar(libro);
        return "Libro creado y guardado con exito!";
    }

    @Override
    public String modificarLibro(Long id, Libro libro) {
        Libro libroActual = libroDAO.buscarPorId(id);


        if (libroActual != null) {
            if (libro.getIsbn() != null) {
                libroActual.setIsbn(libro.getIsbn());
            }
            if (libro.getTitulo() != null) {
                libroActual.setTitulo(libro.getTitulo());
            }
            if (libro.getAnio() != null) {
                libroActual.setAnio(libro.getAnio());
            }
            if (libro.getAnio() != null) {
                libroActual.setEjemplares(libro.getEjemplares());
            }
            if (libro.getEjemplaresPrestados() != null) {
                libroActual.setEjemplaresPrestados(libro.getEjemplaresPrestados());
            }
            if (libro.getEjemplaresRestantes() != null) {
                libroActual.setEjemplaresRestantes(libro.getEjemplaresRestantes());
            }
            if (libro.getAlta() != null) {
                libroActual.setAlta(libro.getAlta());
            }
            if (libro.getAutores() != null) {
                libroActual.setAutores(libro.getAutores());
            }
            if (libro.getEditorial() != null) {
                libroActual.setEditorial(libro.getEditorial());
            }

            libroDAO.actualizar(libroActual);
            return "Libro actualizado con exito!";
        } else {
            return "No existe un libro en el ID dado, actualización no realizada.";
        }
    }

    @Override
    public String darDeBajaLibro(Long id) {
        Libro libro = libroDAO.buscarPorId(id);
        if (libro != null) {
            libroDAO.darDeBaja(id);
            return "El libro se ha dado de baja.";
        } else {
            return "No existe un libro en el ID dado, no se pudo dar de baja.";
        }
    }
}
