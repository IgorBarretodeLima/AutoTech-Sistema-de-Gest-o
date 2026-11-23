package com.dt2.autotech.controller;


import com.dt2.autotech.entities.Peca;
import com.dt2.autotech.repository.PecaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    private final PecaRepository repository;

    public PecaController(PecaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Peca> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Peca> cadastrar( @RequestBody Peca peca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(peca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> atualizar(@PathVariable Long id, @RequestBody Peca dados) {
        return repository.findById(id).map(p -> {
            p.setNome(dados.getNome());
            p.setCodigoFabricante(dados.getCodigoFabricante());
            p.setPrecoUnitario(dados.getPrecoUnitario());
            p.setQuantidadeEstoque(dados.getQuantidadeEstoque());
            return ResponseEntity.ok(repository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}