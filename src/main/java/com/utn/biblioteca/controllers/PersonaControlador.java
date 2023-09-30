package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.services.PersonaServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/personas")
public class PersonaControlador extends ControladorBaseImpl<Persona, PersonaServicioImpl> {
}
