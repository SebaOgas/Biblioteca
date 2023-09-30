package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Libro;
import com.utn.biblioteca.repositories.LibroRepositorio;
import com.utn.biblioteca.repositories.RepositorioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicioImpl extends ServicioBaseImpl<Libro, Long> implements LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    public LibroServicioImpl(RepositorioBase<Libro, Long> repositorioBase, LibroRepositorio libroRepositorio) {
        super(repositorioBase);
        this.libroRepositorio = libroRepositorio;
    }

}
