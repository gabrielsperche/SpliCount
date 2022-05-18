package splitec.service;

import dev.morphia.Datastore;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public boolean verificaModel(Usuario model) {
        return model != null && model.getEmail() != null && model.getSenha() != null;
    }

    public Usuario encontraPorId(ObjectId id) {
        return _repository.findById(id);
    }

    public Usuario criarOuAtualizarUsuario(Usuario usuario) {
        return _repository.saveOrUpdate(usuario);
    }

    public List<Usuario> listaTodos() {
        return _repository.findAll();
    }

    public void deletar(ObjectId id) {
        _repository.deleteById(id);
    }

    public Usuario encontraPorModel(Usuario model) {
        return _repository.findByModel(model);
    }

    //autenticação temporária
    public boolean autenticarUsuario(Usuario model, Usuario usuario) {
        return model.getSenha().equals(usuario.getSenha());
    }
}
