package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.UpdateOptions;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;
import java.util.List;

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

    public boolean existAny(ObjectId id) {
        return id != null && _db.find(Usuario.class).filter(Filters.eq("_id", id)).count() > 0;
    }

    public Usuario findById(ObjectId id) {
        return _db.find(Usuario.class).filter(Filters.eq("_id", id)).first();
    }

    public void saveOrUpdate(Usuario usuario) {
        _db.save(usuario);
    }

    public void update(Usuario usuario) {
        _db.find(Usuario.class).filter(Filters.eq("_id", usuario.getId()));
    }

    public void deleteById(ObjectId id) {
        _db.find(Usuario.class).filter(Filters.eq("_id", id)).delete(new DeleteOptions().multi(false));
    }
}