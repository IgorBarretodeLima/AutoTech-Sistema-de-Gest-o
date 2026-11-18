package com.dt2.autotech.controller;

import com.dt2.autotech.repository.ClienteRepository;
import com.dt2.autotech.entities.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente dados) {
        return repository.findById(id).map(cliente -> {
            cliente.setNome(dados.getNome());
            cliente.setCpf(dados.getCpf());
            cliente.setTelefone(dados.getTelefone());
            cliente.setEmail(dados.getEmail());
            return ResponseEntity.ok(repository.save(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}