package com.dt2.autotech.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String placa;
    private String modelo;
    private String marca;
    private Date ano;
    private Long clienteId;


    public Veiculo(String placa, String modelo, String marca, Date ano, Long clienteId) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.clienteId = clienteId;
    }

    public Veiculo(Long id, String placa, String modelo, String marca, Date ano, Long clienteId) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.clienteId = clienteId;
    }

    public Veiculo() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public Date getAno() { return ano; }
    public void setAno(Date ano) { this.ano = ano; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}