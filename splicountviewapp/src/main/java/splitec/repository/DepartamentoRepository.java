package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MessageResponse;
import splitec.client.Client;

import java.util.HashMap;
import java.util.Map;

public class DepartamentoRepository extends Client {
    public static MessageResponse criaDepartamento(String nome, Double orcamento) {
        Map body = new HashMap<>();
        body.put("nome", nome);
        body.put("orcamento", orcamento);

        try {
            return post("http://localhost:8080/departamento/upsert", new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }
}
