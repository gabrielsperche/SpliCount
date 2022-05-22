package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Departamento;
import splitec.entities.Usuario;
import splitec.repository.dbconnection.DatabaseConnection;

import java.util.List;

public class DepartamentoRepository implements IBaseRepository<Departamento>{

    Datastore _db;

    public DepartamentoRepository() {
        this._db = DatabaseConnection.getConnection();
    }

    @Override
    public List<Departamento> findAll() {
        return _db.find(Departamento.class).iterator().toList();
    }

    @Override
    public boolean existAny(ObjectId id) {
        return id != null && _db.find(Departamento.class).filter(Filters.eq("_id", id)).count() > 0;
    }

    @Override
    public Departamento findById(ObjectId id) {
        return _db.find(Departamento.class).filter(Filters.eq("_id", id)).first();
    }

    @Override
    public Departamento saveOrUpdate(Departamento departamento) {
        return _db.save(departamento);
    }

    @Override
    public void deleteById(ObjectId id) {
        _db.find(Usuario.class).filter(Filters.eq("_id", id)).delete(new DeleteOptions().multi(false));
    }

    @Override
    public Departamento findByModel(Departamento model) {
        Query<Departamento> query = _db.find(Departamento.class).filter(Filters.eq("nome", model.getNome()));


        return query.first();
    }
}
