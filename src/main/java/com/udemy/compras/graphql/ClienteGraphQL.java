package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver,GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRep;

    public Cliente cliente(Long id) {
        return clienteRep.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRep.findAll();
    }

    @Transactional
    public Cliente saveCliente(Long id, String nome, String email) {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setEmail(email);
        return clienteRep.save(c);
    }

    @Transactional
    public Boolean deleteCliente(Long id) {
        if(clienteRep.findById(id).isPresent()) {
            clienteRep.deleteById(id);
            return true;
        }
        return false;
    }
}
