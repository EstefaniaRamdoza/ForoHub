package com.estefania.forohub.forohub.controller;

import com.estefania.forohub.forohub.dto.*;
import com.estefania.forohub.forohub.model.Topico;
import com.estefania.forohub.forohub.model.Usuario;
import com.estefania.forohub.forohub.repository.TopicoRepository;
import com.estefania.forohub.forohub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoRepository repo;
    private final UsuarioRepository usuarioRepo;

    public TopicoController(TopicoRepository repo, UsuarioRepository usuarioRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<Topico> listar() { return repo.findAll(); }

    @PostMapping
    public TopicoResponse crear(@Valid @RequestBody CrearTopicoRequest req) {
        Usuario autor = usuarioRepo.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Topico t = new Topico();
        t.setTitulo(req.getTitulo());
        t.setMensaje(req.getMensaje());
        t.setFechaCreacion(LocalDateTime.now());
        t.setEstado("ABIERTO");
        t.setAutor(autor);

        Topico saved = repo.save(t);

        TopicoResponse r = new TopicoResponse();
        r.setId(saved.getId());
        r.setTitulo(saved.getTitulo());
        r.setMensaje(saved.getMensaje());
        r.setFechaCreacion(saved.getFechaCreacion());
        r.setEstado(saved.getEstado());
        r.setAutorId(autor.getId());
        r.setAutorNombre(autor.getNombre());
        r.setAutorEmail(autor.getEmail());
        return r;
    }

    @PutMapping("/{id}")
    public TopicoResponse actualizar(@PathVariable Long id, @Valid @RequestBody ActualizarTopicoRequest req) {
        Topico t = repo.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        t.setTitulo(req.getTitulo());
        t.setMensaje(req.getMensaje());
        t.setEstado(req.getEstado());
        Topico saved = repo.save(t);

        TopicoResponse r = new TopicoResponse();
        r.setId(saved.getId());
        r.setTitulo(saved.getTitulo());
        r.setMensaje(saved.getMensaje());
        r.setFechaCreacion(saved.getFechaCreacion());
        r.setEstado(saved.getEstado());
        r.setAutorId(saved.getAutor().getId());
        r.setAutorNombre(saved.getAutor().getNombre());
        r.setAutorEmail(saved.getAutor().getEmail());
        return r;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { repo.deleteById(id); }
}