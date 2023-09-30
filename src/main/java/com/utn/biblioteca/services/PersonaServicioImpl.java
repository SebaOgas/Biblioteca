package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Persona;
import com.utn.biblioteca.repositories.PersonaRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImpl extends ServicioBaseImpl<Persona, Long> implements PersonaServicio {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public PersonaServicioImpl(RepositorioBase<Persona, Long> repositorioBase, PersonaRepositorio personaRepositorio) {
        super(repositorioBase);
        this.personaRepositorio = personaRepositorio;
    }

}
