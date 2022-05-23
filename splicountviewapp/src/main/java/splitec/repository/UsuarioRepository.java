package splitec.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.MessageResponse;
import splitec.Constants;
import splitec.client.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;


public class UsuarioRepository extends Client implements Constants {

    public static MessageResponse buscaUsuario(String email, String senha) {
        Map<String, String> body = new HashMap<>();
        body.put(EMAIL, email);
        body.put(SENHA, senha);
        try {
            return post(AUTH, new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }

    public static MessageResponse criaUsuario(String email, String senha, String nome) {
        Map<String, String> body = new HashMap<>();
        body.put(NOME, nome);
        body.put(EMAIL, email);
        body.put(SENHA, senha);

        try {
            return post(UPSERT, new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }

    public static MessageResponse login(String email, String senha) {
        Map<String, String> body = new HashMap<>();
        body.put(EMAIL, email);
        body.put(SENHA, senha);
        try {
            return post(AUTH, new ObjectMapper().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            return new MessageResponse("Objeto inválido", false);
        }
    }
}
