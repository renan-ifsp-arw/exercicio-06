package br.edu.ifsp.dw2.exercicio05.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @Column(name = "data_finalizacao")
    private LocalDate dataFinalizacao;

    private BigDecimal valor;

    private String observacao;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private Status status;
}
