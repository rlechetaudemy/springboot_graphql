package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.ClienteService;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.domain.CompraService;
import com.udemy.compras.domain.ProdutoService;
import com.udemy.compras.graphql.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public List<Compra> getCompras() {
        return service.getCompras();
    }

    public Compra saveCompra(Long id, Integer quantidade, String status, Long clienteId, Long produtoId) {
        Compra c = new Compra();
        c.setId(id);
        c.setQuantidade(quantidade);
        c.setStatus(status);
        c.setData(new Date());
        c.setCliente(clienteService.getClienteById(clienteId));
        c.setProduto(produtoService.getProdutoById(produtoId));

        return service.save(c);
    }

    public Compra saveCompraV2(CompraInput input) {

        if(!input.getStatus().equals("OK")) {
            throw new DomainException("Erro de Teste 2");
        }

        Compra c = new Compra();
        c.setId(input.getId());
        c.setQuantidade(input.getQuantidade());
        c.setStatus(input.getStatus());
        c.setData(new Date());
        c.setCliente(clienteService.getClienteById(input.getClienteId()));
        c.setProduto(produtoService.getProdutoById(input.getProdutoId()));

        return service.save(c);
    }
}
