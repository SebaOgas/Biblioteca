package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Domicilio;
import com.utn.biblioteca.services.DomicilioServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/domicilios")
public class DomicilioControlador extends ControladorBaseImpl<Domicilio, DomicilioServicioImpl> {
}
