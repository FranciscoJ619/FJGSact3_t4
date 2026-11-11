package com.prueba.spring.catalogovideojuegos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prueba.spring.catalogovideojuegos.models.Genero;
import com.prueba.spring.catalogovideojuegos.models.Videojuego;
import com.prueba.spring.catalogovideojuegos.services.GeneroService;
import com.prueba.spring.catalogovideojuegos.services.VideojuegoService;

@Controller
public class VideojuegoController {
    private final VideojuegoService videojuegoService;
    private final GeneroService generoService;
    public VideojuegoController(VideojuegoService videojuegoService, GeneroService generoService) {
        this.videojuegoService = videojuegoService;
        this.generoService = generoService;
    }

    @GetMapping("/videojuegos")
    public String listar(Model model) {
        model.addAttribute("videojuegos", videojuegoService.listarTodos());
        return "videojuegos/index";
    }

    @GetMapping("/videojuegos/nuevo")
    public String nuevo(Model model) {
        Videojuego videojuego = new Videojuego();
        videojuego.setGenero(new Genero());
        model.addAttribute("videojuego", videojuego);
        model.addAttribute("generos", generoService.listarTodos());
        return "videojuegos/form";
    }

    @PostMapping("/videojuegos/guardar")
    public String guardar(Videojuego videojuego, RedirectAttributes redirectAttributes) {
        videojuegoService.guardar(videojuego);
        redirectAttributes.addFlashAttribute("mensaje", "Videojuego guardado correctamente");
        return "redirect:/videojuegos";
    }

    @GetMapping("/videojuegos/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Videojuego videojuego = videojuegoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("No se encontró el videojuego"));

        model.addAttribute("videojuego", videojuego);
        model.addAttribute("generos", generoService.listarTodos());

        return "videojuegos/form";
    }

    @PostMapping("/videojuegos/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        videojuegoService.eliminar(id);

        redirectAttributes.addFlashAttribute("mensaje", "Videojuego eliminado correctamente");
        return "redirect:/videojuegos";
    }
}
