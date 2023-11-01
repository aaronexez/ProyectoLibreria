package com.example.ProyectoLibreria.modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorialTest {
    private Editorial editorial = new Editorial(1L,"Manaos",true);

    @Test
    void getIdTest() {
        assertEquals(1L,editorial.getId());
    }

    @Test
    void getNombreTest() {
        assertEquals("Manaos",editorial.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,editorial.getAlta());
    }

    @Test
    void setIdTest() {
        editorial.setId(2L);
        assertEquals(2L,editorial.getId());
    }

    @Test
    void setNombreTest() {
        editorial.setNombre("Pepsi");
        assertEquals("Pepsi",editorial.getNombre());
    }

    @Test
    void setAltaTest() {
        editorial.setAlta(false);
        assertEquals(false,editorial.getAlta());
    }
}