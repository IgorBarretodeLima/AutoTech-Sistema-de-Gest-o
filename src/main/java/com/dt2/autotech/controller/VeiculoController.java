package com.dt2.autotech.controller;

import com.dt2.autotech.entities.Veiculo;
import com.dt2.autotech.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoRepository repository;

    public VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar( @RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable int id,@RequestBody Veiculo dados) {
        return repository.findById(id).map(v -> {
            v.setPlaca(dados.getPlaca());
            v.setModelo(dados.getModelo());
            v.setMarca(dados.getMarca());
            v.setAno(dados.getAno());
            v.setClienteId(dados.getClienteId());
            return ResponseEntity.ok(repository.save(v));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}