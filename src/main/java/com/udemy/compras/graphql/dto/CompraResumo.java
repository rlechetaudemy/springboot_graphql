package com.udemy.compras.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompraResumo {
    private Long compraId;
    private String cliente;
    private String produto;
    private int quantidade;
}
