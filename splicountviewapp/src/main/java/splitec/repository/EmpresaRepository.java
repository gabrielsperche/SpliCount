package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MessageResponse;
import splitec.client.Client;

import java.util.HashMap;
import java.util.Map;

public class EmpresaRepository extends Client {
    public static MessageResponse criaEmpresa(String nome, String orcamento) {
        Map body = new HashMap<>();
        body.put(NOME, nome);
        body.put(ORCAMENTO, orcamento);

        try {
            return post(EMP_UPSERT, new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }
}