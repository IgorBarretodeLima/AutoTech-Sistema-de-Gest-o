package com.dt2.autotech.controller;

import com.dt2.autotech.entities.OrdemServico;
import com.dt2.autotech.repository.OrdemServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordens")
@CrossOrigin("*")
public class OrdemServicoController {

    private final OrdemServicoRepository repository;

    public OrdemServicoController(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdemServico> cadastrar( @RequestBody OrdemServico ordem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ordem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Long id,@RequestBody OrdemServico dados) {
        return repository.findById(id).map(o -> {
            o.setDescricaoProblema(dados.getDescricaoProblema());
            o.setStatus(dados.getStatus());
            o.setValorTotal(dados.getValorTotal());
            o.setVeiculoId(dados.getVeiculoId());
            o.setMecanicoId(dados.getMecanicoId());
            return ResponseEntity.ok(repository.save(o));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}