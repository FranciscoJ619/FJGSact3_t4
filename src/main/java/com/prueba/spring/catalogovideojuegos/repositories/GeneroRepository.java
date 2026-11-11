package com.prueba.spring.catalogovideojuegos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.spring.catalogovideojuegos.models.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
