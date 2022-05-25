package splitec.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Empresa;
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
        } catch (Exception e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }

    public static Empresa infosEmpresa(String idEmpresa) {
        try{
            String response = get(EMP_FIND.concat(idEmpresa)).getMensagem();

            final var objectMapper = new ObjectMapper();

            return objectMapper.readValue(response, Empresa.class);
        }
        catch (Exception e){
            return null;
        }
    }
}