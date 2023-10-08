package com.utn.biblioteca.integration;

import com.utn.biblioteca.BibliotecaApplication;
import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.repositories.PersonaRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BibliotecaApplication.class)
@AutoConfigureMockMvc
public class PersonaControladorIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepositorio personaRepositorio;

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

        personaRepositorio.save(p);

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
