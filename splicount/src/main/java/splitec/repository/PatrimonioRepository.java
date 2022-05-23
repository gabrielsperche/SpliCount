package splitec.repository;

import dev.morphia.Datastore;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Patrimonio;
import splitec.repository.dbconnection.DatabaseConnection;

import java.util.List;

public class PatrimonioRepository implements IBaseRepository<Patrimonio> {

    Datastore _db;

    public PatrimonioRepository() {
        _db = DatabaseConnection.getConnection();
    }

    public Patrimonio findByEmpresaId(ObjectId empresaId) {
        return _db.find(Patrimonio.class).filter(Filters.eq("empresaId", empresaId)).first();
    }

    @Override
    public List<Patrimonio> findAll() {
        return null;
    }

    @Override
    public boolean existAny(ObjectId id) {
        return false;
    }

    @Override
    public Patrimonio findById(ObjectId id) {
        return null;
    }

    @Override
    public Patrimonio saveOrUpdate(Patrimonio entity) {
        return _db.save(entity);
    }

    @Override
    public void deleteById(ObjectId id) {

    }

    @Override
    public Patrimonio findByModel(Patrimonio model) {
        return null;
    }
}
