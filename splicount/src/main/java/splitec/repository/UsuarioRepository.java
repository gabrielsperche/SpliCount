package splitec.repository;
import dev.morphia.Datastore;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;

/**
 * @author gabrielsperche
 */

public class UsuarioRepository {

    Datastore _db;

    public UsuarioRepository() {
        _db = DatabaseConnection.getConnection();
    }

    //public Usuario findById(Object id) {    }

    public void create(Usuario usuario) {
        _db.save(usuario);
    }
}