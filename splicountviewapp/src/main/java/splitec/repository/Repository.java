package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import splitec.Constants;
import splitec.client.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class Repository extends Client implements Constants {
    public static String buscaUsuario(String email, String senha) throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put(EMAIL, email);
        body.put(SENHA, senha);
        return post(AUTH, new ObjectMapper().writeValueAsString(body));
    }

    public static String criaUsuario(String email, String senha, String nome) throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put(NOME, nome);
        body.put(EMAIL, email);
        body.put(SENHA, senha);
        return post(UPSERT, new ObjectMapper().writeValueAsString(body));
    }
}
