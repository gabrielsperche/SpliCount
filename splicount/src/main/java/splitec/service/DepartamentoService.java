package splitec.service;

import org.bson.types.ObjectId;
import splitec.entities.Departamento;
import splitec.repository.DepartamentoRepository;

import java.util.List;

//casos de usos de departamentos
public class DepartamentoService {

    private final DepartamentoRepository _departamentoRepository;

    public DepartamentoService() {
        _departamentoRepository = new DepartamentoRepository();
    }

    public Departamento criarOuAtualizarDepartamento(Departamento departamento) {
        _departamentoRepository.saveOrUpdate(departamento);
        return departamento;
    }

    public boolean verificaModel(Departamento model) {
        return model != null && model.getNome() != null && model.getOrcamento() != 0;
    }

    public Departamento encontraPorModel(Departamento model) {
        return _departamentoRepository.findByModel(model);
    }

    public Departamento encontraPorId(ObjectId id) {
        return _departamentoRepository.findById(id);
    }

    public List<Departamento> listaTodos() {
        return  _departamentoRepository.findAll();
    }

    public void deletar(ObjectId id) {
        _departamentoRepository.deleteById(id);
    }
}
