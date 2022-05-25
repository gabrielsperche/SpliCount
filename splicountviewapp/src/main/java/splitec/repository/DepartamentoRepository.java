package splitec.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Conta;
import entities.Empresa;
import entities.MessageResponse;
import entities.Nota;
import splitec.client.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartamentoRepository extends Client {
    public static MessageResponse criaDepartamento(String nome, Double orcamento) {
        Map departamento = new HashMap<>();
        departamento.put(NOME, nome);
        departamento.put(ORCAMENTO, orcamento);

        Map body = new HashMap<>();
        body.put(EMPRESA_ID, Conta.getIdEmpresa());
        body.put(DEPARTAMENTO, departamento);

        try {
            return post(DEP_UPSERT, new ObjectMapper().writeValueAsString(body));
        } catch (Exception e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }

    public static List<Nota> buscarNotas() {
        try {
            String response = get(NOTAS_DEP.concat(Conta.getIdEmpresa())).getMensagem();

            final var objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, new TypeReference<List<Nota>>(){});
        } catch (Exception e) {
            return null;
        }
    }
}
