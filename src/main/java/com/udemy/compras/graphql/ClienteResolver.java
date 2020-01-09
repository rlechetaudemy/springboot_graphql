package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.domain.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente c) {
        return compraService.findAllByCliente(c);
    }
}
