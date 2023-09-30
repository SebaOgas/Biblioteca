package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.repositories.AutorRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicioImpl extends ServicioBaseImpl<Autor, Long> implements AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    public AutorServicioImpl(RepositorioBase<Autor, Long> repositorioBase, AutorRepositorio autorRepositorio) {
        super(repositorioBase);
        this.autorRepositorio = autorRepositorio;
    }

}
