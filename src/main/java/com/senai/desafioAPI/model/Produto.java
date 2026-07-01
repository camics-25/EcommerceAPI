package com.senai.desafioAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int id;
}
