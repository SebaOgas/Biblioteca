package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.services.AutorServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/autores")
public class AutorControlador extends ControladorBaseImpl<Autor, AutorServicioImpl> {
}
