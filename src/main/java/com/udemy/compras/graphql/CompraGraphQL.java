package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.ClienteService;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.domain.CompraService;
import com.udemy.compras.domain.ProdutoService;
import com.udemy.compras.graphql.dto.CompraResumo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Compra compra(Long id) {
        return service.findById(id);
    }

    public List<Compra> getCompras(int page, int size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by("quantidade"));
        return service.findAll(pageable);
    }

    public List<CompraResumo> getComprasRelatorio() {
        return service.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input,Compra.class);

        c.setData(new Date());

        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));

        return service.save(c);
    }

    public Boolean deleteCompra(Long id) {
        return service.deleteById(id);
    }
}
