package com.udemy.compras.graphql;

import lombok.Data;

@Data
public class ProdutoInput {

    private Long id;
    private String nome;
    private double valor;
}
