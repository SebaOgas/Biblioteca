package com.utn.biblioteca.repositories;

import com.utn.biblioteca.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends RepositorioBase<Persona, Long>{

    Page<Persona> findByNombreContaining(String nombre, Pageable pageable);

    @Query(
            value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre%"
    )
    Page<Persona> buscarPorNombreJPQL(@Param("nombre") String nombre, Pageable pageable);

    @Query(
            value = "SELECT * FROM Persona p WHERE p.nombre LIKE %:nombre%",
            nativeQuery = true
    )
    Page<Persona> buscarPorNombreNative(@Param("nombre") String nombre, Pageable pageable);

    @Query(
            value = "SELECT p, COUNT(*) Cantidad_Libros " +
                    "FROM Persona p LEFT JOIN p.libros l " +
                    "GROUP BY p.id " +
                    "HAVING COUNT(*) >= :min AND COUNT(*) <= :max " +
                    "ORDER BY COUNT(*) DESC"
    )
    Page<Persona> buscarPorCantLibros(@Param("min") Integer min, @Param("max") Integer max, Pageable pageable);
}
