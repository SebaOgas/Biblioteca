package com.utn.biblioteca.repositories;

import com.utn.biblioteca.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends RepositorioBase<Libro, Long> {
}
