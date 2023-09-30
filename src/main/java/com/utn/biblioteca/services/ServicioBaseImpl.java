package com.utn.biblioteca.services;

import com.utn.biblioteca.entities.Autor;
import com.utn.biblioteca.entities.EntidadBase;
import com.utn.biblioteca.repositories.RepositorioBase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ServicioBaseImpl<E extends EntidadBase, ID extends Serializable> implements ServicioBase<E, ID> {
    protected RepositorioBase<E, ID> repositorioBase;


    public ServicioBaseImpl(RepositorioBase<E, ID> repositorioBase) {
        this.repositorioBase = repositorioBase;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = repositorioBase.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = repositorioBase.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = repositorioBase.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = repositorioBase.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = repositorioBase.save(entity);
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(repositorioBase.existsById(id)){
                repositorioBase.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
