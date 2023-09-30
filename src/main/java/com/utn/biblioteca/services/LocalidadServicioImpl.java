package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Localidad;
import com.utn.biblioteca.repositories.LocalidadRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServicioImpl extends ServicioBaseImpl<Localidad, Long> implements LocalidadServicio {

    @Autowired
    private LocalidadRepositorio localidadRepositorio;

    public LocalidadServicioImpl(RepositorioBase<Localidad, Long> repositorioBase, LocalidadRepositorio localidadRepositorio) {
        super(repositorioBase);
        this.localidadRepositorio = localidadRepositorio;
    }

}
