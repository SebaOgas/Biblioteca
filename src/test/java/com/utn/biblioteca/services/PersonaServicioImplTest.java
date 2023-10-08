package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.repositories.PersonaRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonaServicioImplTest {
    @MockBean
    private PersonaRepositorio personaRepositorio;

    @Autowired
    private PersonaServicioImpl personaServicio;

    @Test
    void testBuscarPorNombreJPQL() throws Exception{
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

        List<Persona> personas = new ArrayList<>();
        personas.add(p);

        Pageable pageable = PageRequest.of(0, 5);

        Page<Persona> personaPage = new PageImpl<>(personas, pageable, 0);

        when(personaRepositorio.buscarPorNombreJPQL("cc", pageable)).thenReturn(personaPage);


        assertEquals(personas, personaServicio.buscarPorNombreJPQL("cc", pageable).getContent());
    }
}
