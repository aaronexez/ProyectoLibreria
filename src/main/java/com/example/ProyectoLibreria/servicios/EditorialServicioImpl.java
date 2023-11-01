package com.example.ProyectoLibreria.servicios;

import com.example.ProyectoLibreria.modelos.Editorial;
import com.example.ProyectoLibreria.repositorios.EditorialDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialServicioImpl implements EditorialServicio {

    private final EditorialDAO editorialDAO;

    @Override
    public List<Editorial> listarEditoriales() {
        return editorialDAO.buscarTodos();
    }

    @Override
    public String crearEditorial(Editorial editorial) {
        editorialDAO.guardar(editorial);
        return "Editorial creada y guardada con exito!";
    }

    @Override
    public String modificarEditorial(Long id, Editorial editorial) {
        Editorial editorialActual = editorialDAO.buscarPorId(id);

        if (editorialActual != null) {
            if (editorial.getNombre() != null) {
                editorialActual.setNombre(editorial.getNombre());
            }
            if (editorial.getAlta() != null) {
                editorialActual.setAlta(editorial.getAlta());
            }

            editorialDAO.actualizar(editorialActual);
            return "Editorial actualizada con exito!";
        } else {
            return "No existe una editorial en el ID dado, actualización no realizada.";
        }
    }

    @Override
    public String darDeBajaEditorial(Long id) {
        Editorial editorial = editorialDAO.buscarPorId(id);
        if (editorial != null) {
            editorialDAO.darDeBaja(id);
            return "La editorial se ha dado de baja.";
        } else {
            return "No existe una editorial en el ID dado, no se pudo dar de baja.";
        }
    }
}
