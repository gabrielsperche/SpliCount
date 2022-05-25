package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Departamento;
import splitec.entities.Empresa;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;

import java.util.List;

public class EmpresaRepository implements IBaseRepository<Empresa>{

    Datastore _db;

    public EmpresaRepository() {
       _db = DatabaseConnection.getConnection();
    }

    @Override
    public List<Empresa> findAll() {
        return _db.find(Empresa.class).iterator().toList();
    }

    @Override
    public boolean existAny(ObjectId id) {
        return _db.find(Empresa.class).filter(Filters.eq("_id", id)).count() > 0;
    }

    @Override
    public Empresa findById(ObjectId id) {
        return _db.find(Empresa.class).filter(Filters.eq("_id", id)).first();
    }

    @Override
    public Empresa saveOrUpdate(Empresa entity) {
        return _db.save(entity);
    }

    @Override
    public void deleteById(ObjectId id) {
        _db.find(Empresa.class).filter(Filters.eq("_id", id)).delete(new DeleteOptions().multi(false));
    }

    @Override
    public Empresa findByModel(Empresa model) {
        Query<Empresa> query = _db.find(Empresa.class).filter(Filters.eq("nome", model.getNome()));
        return query.first();
    }
}
