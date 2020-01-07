package com.udemy.compras.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;

}
