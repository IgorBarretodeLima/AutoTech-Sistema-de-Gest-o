package com.dt2.autotech.controller;

import com.dt2.autotech.entities.Mecanico;
import com.dt2.autotech.repository.MecanicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mecanicos")
@CrossOrigin(origins = "*")
public class MecanicoController {

    private final MecanicoRepository repository;

    public MecanicoController(MecanicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Mecanico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mecanico> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mecanico> cadastrar(@RequestBody Mecanico mecanico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(mecanico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mecanico> atualizar(@PathVariable Long id, @RequestBody Mecanico dados) {
        return repository.findById(id).map(m -> {
            m.setNome(dados.getNome());
            m.setEspecialidade(dados.getEspecialidade());
            m.setRegistroProfissional(dados.getRegistroProfissional());
            return ResponseEntity.ok(repository.save(m));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}