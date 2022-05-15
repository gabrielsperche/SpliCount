package splitec.service;

import org.apache.commons.lang3.StringUtils;
import splitec.entities.User;
import splitec.repository.Repository;

public class Service extends Repository {

    public String auth(User user) throws Exception {
        String username = user.getName();
        String password = user.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new Exception("Usuário e/ou Senha não pode ser nulo ou vazio!");
        } else {
            return (validateLogin(username, password)) ? "Sucesso" : "Erro";
        }
    }
}
