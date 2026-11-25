package com.dt2.autotech.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;

@Entity
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String codigoFabricante;
    @NotNull
    private BigDecimal precoUnitario;
    @NotNull
    private Integer quantidadeEstoque;

    public Peca(String nome, String codigoFabricante, BigDecimal precoUnitario, Integer quantidadeEstoque) {
        this.nome = nome;
        this.codigoFabricante = codigoFabricante;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Peca(Long id, String nome, String codigoFabricante, BigDecimal precoUnitario, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.codigoFabricante = codigoFabricante;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Peca() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCodigoFabricante() { return codigoFabricante; }
    public void setCodigoFabricante(String codigoFabricante) { this.codigoFabricante = codigoFabricante; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
}