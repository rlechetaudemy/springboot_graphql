package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Cliente cliente() {
        return new Cliente("Ricardo","r@gmail.com");
    }

    public List<Cliente> clientes() {
        List<Cliente> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Cliente("Cliente " + i, "r"+i+"@gmail.com"));
        }
        return list;
    }

}
