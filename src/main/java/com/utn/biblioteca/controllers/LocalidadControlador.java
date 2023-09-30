package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Localidad;
import com.utn.biblioteca.services.LocalidadServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/localidades")
public class LocalidadControlador extends ControladorBaseImpl<Localidad, LocalidadServicioImpl> {
}
