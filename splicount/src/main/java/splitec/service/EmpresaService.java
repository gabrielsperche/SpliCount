package splitec.service;

import org.bson.types.ObjectId;
import splitec.entities.Empresa;
import splitec.repository.EmpresaRepository;

import java.util.List;

public class EmpresaService {

    private final EmpresaRepository _repository;

    public EmpresaService() {
        _repository = new EmpresaRepository();
    }

    public boolean verificaModel(Empresa model) {
        return model != null && model.getNome() != null;
    }

    public Empresa encontraPorModel(Empresa model) {
        return _repository.findByModel(model);
    }

    public Empresa criarOuAtualizarEmpresa(Empresa model) {
        return _repository.saveOrUpdate(model);
    }

    public void deletar(ObjectId id) {
        _repository.deleteById(id);
    }

    public Empresa encontraPorId(ObjectId id) {
        return _repository.findById(id);
    }

    public List<Empresa> listaTodos() {
        return _repository.findAll();
    }
}
