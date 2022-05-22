package splitec.repository;

import dev.morphia.DeleteOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;

import java.util.List;

public interface IBaseRepository<T> {

    List<T> findAll();

    boolean existAny(ObjectId id);

    T findById(ObjectId id);

    T saveOrUpdate(T entity);

    void deleteById(ObjectId id);

    T findByModel(T model);
}
