package splitec.service;

import dev.morphia.Datastore;
import org.bson.types.ObjectId;
import splitec.entities.Usuario;
import splitec.repository.UsuarioRepository;
import splitec.repository.dbconnection.DatabaseConnection;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository _repository;

    public UsuarioService() {
        _repository = new UsuarioRepository();
    }

    public UsuarioService(UsuarioRepository repository) {
        _repository = repository;
    }

    public void verificaUsuario(Usuario user) {
    }

    public Usuario encontraPorId(ObjectId id) {
        return _repository.findById(id);
    }

    public void criarUsuario(Usuario usuario) {
        _repository.saveOrUpdate(usuario);
    }

    public List<Usuario> listaTodos() {
        return _repository.findAll();
    }
}
