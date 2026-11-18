package com.dt2.autotech.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricaoProblema;
    private String status;
    private BigDecimal valorTotal;
    private LocalDateTime dataAbertura = LocalDateTime.now();
    private Long veiculoId;
    private Long mecanicoId;

    public OrdemServico(String descricaoProblema, String status, BigDecimal valorTotal, LocalDateTime dataAbertura, Long veiculoId, Long mecanicoId) {
        this.descricaoProblema = descricaoProblema;
        this.status = status;
        this.valorTotal = valorTotal;
        this.dataAbertura = dataAbertura;
        this.veiculoId = veiculoId;
        this.mecanicoId = mecanicoId;
    }

    public OrdemServico(Long id, String descricaoProblema, String status, BigDecimal valorTotal, LocalDateTime dataAbertura, Long veiculoId, Long mecanicoId) {
        this.id = id;
        this.descricaoProblema = descricaoProblema;
        this.status = status;
        this.valorTotal = valorTotal;
        this.dataAbertura = dataAbertura;
        this.veiculoId = veiculoId;
        this.mecanicoId = mecanicoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricaoProblema() { return descricaoProblema; }
    public void setDescricaoProblema(String descricaoProblema) { this.descricaoProblema = descricaoProblema; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public Long getMecanicoId() { return mecanicoId; }
    public void setMecanicoId(Long mecanicoId) { this.mecanicoId = mecanicoId; }
}