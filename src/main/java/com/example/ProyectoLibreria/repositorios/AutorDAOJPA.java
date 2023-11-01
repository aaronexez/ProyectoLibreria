package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Autor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AutorDAOJPA implements AutorDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void guardar(Autor autor) {
        entityManager.merge(autor);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void actualizar(Autor autor) {
        entityManager.merge(autor);
    }

    @Override
    public Autor buscarPorId(Long id) {
        return entityManager.find(Autor.class, id);
    }

    @Override
    public List<Autor> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Autor p WHERE alta = true ORDER BY id ASC", Autor.class).getResultList();
    }

    @Override
    @Transactional
    public void darDeBaja(Long id) {
        Autor autor = entityManager.find(Autor.class, id);
        if (autor != null) {
            autor.setAlta(false);
        }
    }
}
