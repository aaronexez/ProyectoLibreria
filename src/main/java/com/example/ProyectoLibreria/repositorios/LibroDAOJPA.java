package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Autor;
import com.example.ProyectoLibreria.modelos.Editorial;
import com.example.ProyectoLibreria.modelos.Libro;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@ComponentScan(basePackages = "com.example.ProyectoLibreria")
@RequiredArgsConstructor
public class LibroDAOJPA implements LibroDAO {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void guardar(Libro libro) {
        for (Autor autor : libro.getAutores()) {
            if (autor != null && autor.getId() == null) {
                entityManager.merge(autor);
            }
        }

        Editorial editorial = libro.getEditorial();
        if (editorial != null && editorial.getId() == null) {
            entityManager.merge(editorial);
        }

        entityManager.merge(libro);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void actualizar(Libro libro) {
        entityManager.merge(libro);
    }

    @Override
    public Libro buscarPorId(Long id) {
        return entityManager.find(Libro.class, id);
    }

    @Override
    public List<Libro> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Libro p WHERE alta = true ORDER BY id ASC", Libro.class).getResultList();
    }

    @Override
    @Transactional
    public void darDeBaja(Long id) {
        Libro libro = entityManager.find(Libro.class, id);
        if (libro != null) {
            libro.setAlta(false);
        }
    }
}
