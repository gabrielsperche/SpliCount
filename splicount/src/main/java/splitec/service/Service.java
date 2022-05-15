package splitec.service;

import org.apache.commons.lang3.StringUtils;
import splitec.entities.User;
import splitec.repository.Repository;

/**
 * @author gabrielsperche
 */

public class Service extends Repository {

    //Method to validate user credentials
    public String authService(User user) throws Exception {
        String username = user.getName();
        String password = user.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new Exception("Usuário e/ou Senha não pode ser nulo ou vazio!");
        } else {
            return (validateLogin(username, password)) ? "Sucesso" : "Erro";
        }
    }

    //Method to create a new user
    public String createUserService(User user) throws Exception {
        String username = user.getName();
        String password = user.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new Exception("Usuário e/ou Senha não pode ser nulo ou vazio!");
        } else {
            return (createNewUser(username, password)) ? "Sucesso" : "Erro";
        }
    }

}
