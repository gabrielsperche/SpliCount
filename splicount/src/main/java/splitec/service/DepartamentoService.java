package splitec.service;

import splitec.entities.Departamento;
import splitec.repository.DepartamentoRepository;

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
}
