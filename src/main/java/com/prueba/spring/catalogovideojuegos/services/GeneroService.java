package com.prueba.spring.catalogovideojuegos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prueba.spring.catalogovideojuegos.models.Genero;
import com.prueba.spring.catalogovideojuegos.repositories.GeneroRepository;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Optional<Genero> buscarPorId(Integer id) {
        return generoRepository.findById(id);
    }

    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }

    public void eliminar(Integer id) {
        generoRepository.deleteById(id);
    }
}
