package com.udemy.compras;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.udemy.compras.domain.Cliente;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteGraphQLTest extends GraphQLTestTemplate {

    @Test
    public void testClientes() throws IOException, JSONException {

        GraphQLResponse response = perform("cliente.graphql", null);

        assertTrue(response.isOk());

        String json = response.getRawResponse().getBody();
        System.out.println("Body: " + json);

        JSONArray jC = new JSONObject(json).getJSONObject("data").getJSONArray("clientes");
        System.out.println(jC);

        ObjectMapper mapper = new ObjectMapper();

        List<Cliente> clientes = mapper.readValue(jC.toString(), new TypeReference<List<Cliente>>(){});

        clientes.forEach(c -> System.out.println(c.getNome()));
    }
}
