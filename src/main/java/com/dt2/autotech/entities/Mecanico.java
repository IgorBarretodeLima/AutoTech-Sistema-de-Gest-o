package com.dt2.autotech.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mecanicos")
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String especialidade;
    @NotBlank
    private String registroProfissional;


    public Mecanico(String nome, String especialidade, String registroProfissional) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public Mecanico(Long id, String nome, String especialidade, String registroProfissional) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public Mecanico() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
}
