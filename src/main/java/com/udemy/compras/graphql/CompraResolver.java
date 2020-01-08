package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra c) {
        return "Teste : " + c.getStatus();
    }

    public Cliente cliente(Compra c) {
        return clienteService.findById(c.getCliente().getId());
    }

    public Produto produto(Compra c) {
        return produtoService.findById(c.getProduto().getId());
    }
}
