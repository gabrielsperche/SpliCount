package splitec.service;

import entities.Conta;
import entities.MessageResponse;
import splitec.repository.UsuarioRepository;

public class UsuarioService extends UsuarioRepository {

    public static MessageResponse auth(String email, String senha) {
        MessageResponse response = buscaUsuario(email, senha);
        Conta.setIdEmpresa(response.getMensagem());
        return new MessageResponse("", response.isSucess());
    }

    public static MessageResponse createUser(String email, String senha, String nome, String empresa) throws Exception {
        return criaUsuario(email, senha, nome, empresa);
    }
}
