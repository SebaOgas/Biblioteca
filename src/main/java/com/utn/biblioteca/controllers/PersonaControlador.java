package com.utn.biblioteca.controllers;

import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.services.PersonaServicioImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/personas")
public class PersonaControlador extends ControladorBaseImpl<Persona, PersonaServicioImpl> {

    @GetMapping("/buscarPorNombreQueryMethod")
    public ResponseEntity<?> buscarPorNombreQueryMethod(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreQueryMethod(nombre, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorNombreJPQL")
    public ResponseEntity<?> buscarPorNombreJPQL(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreJPQL(nombre, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorNombreNative")
    public ResponseEntity<?> buscarPorNombreNative(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreNative(nombre, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorCantLibros")
    public ResponseEntity<?> buscarPorCantLibros(@RequestParam Integer min, @RequestParam Integer max, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCantLibros(min, max, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
