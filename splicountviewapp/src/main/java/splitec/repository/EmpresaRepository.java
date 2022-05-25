package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Departamento;
import entities.Empresa;
import entities.MessageResponse;
import splitec.client.Client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    public static Empresa infosEmpresa(String idEmpresa) {
        List<Departamento> departs = Arrays.asList(new Departamento("Vendas", 500.0), new Departamento("RH", 300.0));
        return new Empresa("Splitec", "500", departs);
    }
}