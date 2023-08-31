package br.edu.ifsp.dw2.exercicio05.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
