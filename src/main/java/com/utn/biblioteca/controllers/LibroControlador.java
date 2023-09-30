package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.services.LibroServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/libros")
public class LibroControlador extends ControladorBaseImpl<Libro, LibroServicioImpl> {
}
