package splitec.service;

import dev.morphia.Datastore;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;
import splitec.repository.UsuarioRepository;
import splitec.repository.dbconnection.DatabaseConnection;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService() {
        repository = new UsuarioRepository();
    }

    public void verifyUser(Usuario user) {
    }

    public Usuario getById(ObjectId id) {
        return null;
    }

    public void createUser(Usuario usuario) {
        repository.create(usuario);
    }
}
