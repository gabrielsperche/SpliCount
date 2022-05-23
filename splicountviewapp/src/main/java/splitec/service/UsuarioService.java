package splitec.service;

import entities.MessageResponse;
import splitec.repository.UsuarioRepository;

public class UsuarioService extends UsuarioRepository {

    //TODO: Criar validação e mensagem de erro bonitinha pro front
    public static MessageResponse auth(String email, String senha) {
        return buscaUsuario(email, senha);
    }

    public static MessageResponse createUser(String email, String senha, String nome) throws Exception {
        return criaUsuario(email, senha, nome);
    }

    public static void main(String args[]) throws Exception {
        createUser("gabriel@gmail.com", "faculdade", "Gabriel");
        auth("gabriel@gmail.com", "faculdade");
    }
}
