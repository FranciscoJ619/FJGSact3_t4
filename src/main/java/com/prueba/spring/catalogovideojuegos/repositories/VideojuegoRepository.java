package com.prueba.spring.catalogovideojuegos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.spring.catalogovideojuegos.models.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {

}
