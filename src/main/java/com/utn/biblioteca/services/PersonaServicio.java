package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonaServicio extends ServicioBase<Persona, Long>{
    Page<Persona> buscarPorNombreQueryMethod(String nombre, Pageable pageable) throws Exception;
    Page<Persona> buscarPorNombreJPQL(String nombre, Pageable pageable) throws Exception;
    Page<Persona> buscarPorNombreNative(String nombre, Pageable pageable) throws Exception;
    Page<Persona> buscarPorCantLibros(Integer min, Integer max, Pageable pageable) throws Exception;

}
