package br.edu.ifsp.dw2.exercicio05.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "forma_pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;
}
