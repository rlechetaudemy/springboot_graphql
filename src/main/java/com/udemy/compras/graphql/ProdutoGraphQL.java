package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.Produto;
import com.udemy.compras.domain.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ProdutoService service;

    public List<Produto> getProdutos() {
        return service.getProdutos();
    }
}
