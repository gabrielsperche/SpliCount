package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author gabrielsperche
 */

public class UsuarioRepository {

    Datastore _db;

    public UsuarioRepository() {
        _db = DatabaseConnection.getConnection();
    }

    public List<Usuario> findAll() {
        return _db.find(Usuario.class).iterator().toList();
    }

    public Usuario findById(ObjectId id) {
        for (Usuario u: findAll()) {
            if (u.getId().equals(id))
                return u;
        }
        return null;
    }

    public void saveOrUpdate(Usuario usuario) {
        _db.save(usuario);
    }
}