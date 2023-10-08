package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.services.PersonaServicioImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(PersonaControlador.class)
public class PersonaControladorTest {
    @MockBean
    private PersonaServicioImpl personaServicio;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testBuscarPorNombreJPQL() throws Exception {
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

        when(personaServicio.buscarPorNombreJPQL("cc", pageable)).thenReturn(personaPage);

        mockMvc.perform(get("/api/personas/buscarPorNombreJPQL")
                .param("nombre", "cc")
                .param("page", "0")
                .param("size", "5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nombre", is("Lucca")))
                .andExpect(jsonPath("$.content[0].apellido", is("Burgos")));
    }
}
