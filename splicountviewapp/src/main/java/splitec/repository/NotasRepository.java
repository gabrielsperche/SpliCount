package splitec.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MessageResponse;
import splitec.client.Client;

import java.util.HashMap;
import java.util.Map;

public class NotasRepository extends Client {
    public static MessageResponse criaNota(String nome, String tipo, Double valor) {
        try {
            Map body = new HashMap<>();
            body.put("nomeDepartamento", nome);
            body.put("valor", valor);

            if(tipo == "Entrada"){
                return post(ENTRADA_UPSERT, new ObjectMapper().writeValueAsString(body));
            }
            else{
                return post(SAIDA_UPSERT, new ObjectMapper().writeValueAsString(body));
            }


        } catch (Exception e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }
}
