package splitec.service;

import splitec.repository.Repository;

public class Service extends Repository {
    public String getUserName(String id) {
        String repoResponse = null;
        if (id.equals("123")) {
            repoResponse = userName(id);
        }
        String response = "Username: " + " " + repoResponse + "ID: " + id;
        return response;
    }
}
