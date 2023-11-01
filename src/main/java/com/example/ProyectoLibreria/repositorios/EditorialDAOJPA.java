package com.example.ProyectoLibreria.repositorios;

import com.example.ProyectoLibreria.modelos.Editorial;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EditorialDAOJPA implements EditorialDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void guardar(Editorial editorial) {
        entityManager.merge(editorial);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void actualizar(Editorial editorial) {
        entityManager.merge(editorial);
    }

    @Override
    public Editorial buscarPorId(Long id) {
        return entityManager.find(Editorial.class, id);
    }

    @Override
    public List<Editorial> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Editorial p WHERE alta = true ORDER BY id ASC", Editorial.class).getResultList();
    }

    @Override
    @Transactional
    public void darDeBaja(Long id) {
        Editorial editorial = entityManager.find(Editorial.class, id);
        if (editorial != null) {
            editorial.setAlta(false);
        }
    }
}
