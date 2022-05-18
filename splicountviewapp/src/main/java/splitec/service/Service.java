package splitec.service;

import splitec.repository.Repository;

public class Service extends Repository {

    //TODO: Criar validação e mensagem de erro bonitinha pro front
    public static String auth(String email, String senha) throws Exception {
        return buscaUsuario(email, senha);
    }

    public static String createUser(String email, String senha, String nome) throws Exception {
        return criaUsuario(email, senha, nome);
    }

    public static void main(String args[]) throws Exception {
        createUser("gabriel@gmail.com", "faculdade", "Gabriel");
        auth("gabriel@gmail.com", "faculdade");
    }
}
