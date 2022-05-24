package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Conta;
import entities.MessageResponse;
import splitec.client.Client;

import java.util.HashMap;
import java.util.Map;

public class DepartamentoRepository extends Client {
    public static MessageResponse criaDepartamento(String nome, Double orcamento) {
        Conta conta = new Conta();
        Map departamento = new HashMap<>();
        departamento.put(NOME, nome);
        departamento.put(ORCAMENTO, orcamento);

        Map body = new HashMap<>();
        body.put(EMPRESA_ID, conta.getIdEmpresa());
        body.put(DEPARTAMENTO, departamento);

        try {
            return post(DEP_UPSERT, new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }
}
