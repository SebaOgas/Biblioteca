package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Domicilio;
import com.utn.biblioteca.repositories.DomicilioRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServicioImpl extends ServicioBaseImpl<Domicilio, Long> implements DomicilioServicio {

    @Autowired
    private DomicilioRepositorio domicilioRepositorio;

    public DomicilioServicioImpl(RepositorioBase<Domicilio, Long> repositorioBase, DomicilioRepositorio domicilioRepositorio) {
        super(repositorioBase);
        this.domicilioRepositorio = domicilioRepositorio;
    }
}
