package com.utn.biblioteca.repositories;

import com.utn.biblioteca.entities.EntidadBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface RepositorioBase <E extends EntidadBase, ID extends Serializable> extends JpaRepository<E, ID> {
}
