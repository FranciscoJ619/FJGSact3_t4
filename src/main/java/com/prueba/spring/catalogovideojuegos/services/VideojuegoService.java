package com.prueba.spring.catalogovideojuegos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prueba.spring.catalogovideojuegos.models.Genero;
import com.prueba.spring.catalogovideojuegos.models.Videojuego;
import com.prueba.spring.catalogovideojuegos.repositories.GeneroRepository;
import com.prueba.spring.catalogovideojuegos.repositories.VideojuegoRepository;

@Service
public class VideojuegoService {
    private final VideojuegoRepository videojuegoRepository;
    private final GeneroRepository generoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository, GeneroRepository generoRepository) {
        this.videojuegoRepository = videojuegoRepository;
        this.generoRepository = generoRepository;
    }

    public List<Videojuego> listarTodos() {
        return videojuegoRepository.findAll();
    }

    public Optional<Videojuego> buscarPorId(Integer id) {
        return videojuegoRepository.findById(id);
    }

    public Videojuego guardar(Videojuego videojuego) {
        Integer generoId = videojuego.getGenero().getId();
        Genero genero = generoRepository.findById(generoId).orElseThrow(() -> new IllegalArgumentException("El género seleccionado no existe"));
        videojuego.setGenero(genero);
        return videojuegoRepository.save(videojuego);
    }

    public void eliminar(Integer id) {
        videojuegoRepository.deleteById(id);
    }
}
