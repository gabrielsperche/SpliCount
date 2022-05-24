package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.UpdateOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;
import java.util.List;

/**
 * @author gabrielsperche
 */

public class UsuarioRepository implements IBaseRepository<Usuario>{

    Datastore _db;

    public UsuarioRepository() {
        _db = DatabaseConnection.getConnection();
    }

    @Override
    public List<Usuario> findAll() {
        return _db.find(Usuario.class).iterator().toList();
    }

    @Override
    public boolean existAny(ObjectId id) {
        return id != null && _db.find(Usuario.class).filter(Filters.eq("_id", id)).count() > 0;
    }

    @Override
    public Usuario findById(ObjectId id) {
        return _db.find(Usuario.class).filter(Filters.eq("_id", id)).first();
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return _db.save(usuario);
    }

    @Override
    public void deleteById(ObjectId id) {
        _db.find(Usuario.class).filter(Filters.eq("_id", id)).delete(new DeleteOptions().multi(false));
    }

    @Override
    public Usuario findByModel(Usuario model) {
        Query<Usuario> usuarioQuery = _db.find(Usuario.class).filter(Filters.eq("email", model.getEmail()));
        return usuarioQuery.first();
    }

}