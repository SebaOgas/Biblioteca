package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.repositories.PersonaRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImpl extends ServicioBaseImpl<Persona, Long> implements PersonaServicio {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public PersonaServicioImpl(RepositorioBase<Persona, Long> repositorioBase, PersonaRepositorio personaRepositorio) {
        super(repositorioBase);
        this.personaRepositorio = personaRepositorio;
    }

    @Override
    public Page<Persona> buscarPorNombreQueryMethod(String nombre, Pageable pageable) throws Exception {
        try {
            return personaRepositorio.findByNombreContaining(nombre, pageable);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> buscarPorNombreJPQL(String nombre, Pageable pageable) throws Exception {
        try {
            return personaRepositorio.buscarPorNombreJPQL(nombre, pageable);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> buscarPorNombreNative(String nombre, Pageable pageable) throws Exception {
        try {
            return personaRepositorio.buscarPorNombreNative(nombre, pageable);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> buscarPorCantLibros(Integer min, Integer max, Pageable pageable) throws Exception {
        try {
            return personaRepositorio.buscarPorCantLibros(min, max, pageable);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
