package com.utn.biblioteca.repositories;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.entities.Persona;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PersonaRepositorioTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Test
    void testBuscarPorNombreJPQL() {
        Persona p = new Persona();

        List<Libro> libros = new ArrayList<>();

        Libro l = new Libro();
        l.setFecha(4042004);
        l.setTitulo("Título del libro");
        l.setGenero("Drama");
        l.setPaginas(400);
        l.setAutores(new ArrayList<Autor>());

        libros.add(l);

        p.setLibros(libros);
        p.setDni(44444444);
        p.setNombre("Lucca");
        p.setApellido("Burgos");

        entityManager.persist(p);
        entityManager.flush();

        List<Persona> personas = new ArrayList<>();
        personas.add(p);

        Pageable pageable = PageRequest.of(0, 5);

        assertEquals(personas, personaRepositorio.buscarPorNombreJPQL("cc", pageable).getContent());
    }
}
