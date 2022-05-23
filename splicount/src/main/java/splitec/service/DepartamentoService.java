package splitec.service;

import org.bson.types.ObjectId;
import splitec.entities.*;
import splitec.entities.DTO.DepartamentoValor;
import splitec.entities.DTO.ValorDTO;
import splitec.entities.enums.TipoInsercao;
import splitec.repository.DepartamentoRepository;
import splitec.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;

//casos de usos de departamentos
public class DepartamentoService {

    private final DepartamentoRepository _departamentoRepository;
    private final EmpresaService _empresaService;

    public DepartamentoService() {
        _departamentoRepository = new DepartamentoRepository();
        _empresaService = new EmpresaService();
    }

    public Departamento criarOuAtualizarDepartamento(ObjectId idEmpresa, Departamento departamento) {

        _departamentoRepository.saveOrUpdate(departamento);

        Empresa empresa = _empresaService.encontraPorId(idEmpresa);
        if (departamento.getId() != null && !empresa.getDepartamentosIds().contains(departamento.getId())) {
            empresa.addDepartamento(departamento.getId());
            _empresaService.criarOuAtualizarEmpresa(empresa);
        }

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

    public List<Departamento> encontraPorId(List<ObjectId> departamentosIds) {
        if (departamentosIds == null || departamentosIds.isEmpty())
            return null;
        return _departamentoRepository.findAll(departamentosIds);
    }

    public List<DepartamentoValor> getValorTotalPorEmpresa(ObjectId idEmpresa) {
        Empresa empresa = _empresaService.encontraPorId(idEmpresa);

        List<Departamento> departamentoList = encontraPorId(empresa.getDepartamentosIds());

        if (departamentoList == null)
            return null;

        List<DepartamentoValor> valores = new ArrayList<>();

        for (Departamento dept: departamentoList) {
            dept.calculaValorTotal();
            valores.add(new DepartamentoValor(dept.getNome(), dept.getValorTotal(), dept.getValorTotalEntradas(), dept.getValorTotalSaidas()));
        }
        return valores;
    }

    public boolean adicionaValor(ValorDTO model) {
        Departamento departamento = encontraPorId(model.getDepartamentoId());

        if (model.getTipo().equals(TipoInsercao.ENTRADA))
            departamento.addEntrada(new Entrada(model.getValor(), departamento.getId()));
        else if (model.getTipo().equals(TipoInsercao.SAIDA))
            departamento.addSaida(new Saida(model.getValor(), departamento.getId()));
        else
            return false;

        _departamentoRepository.saveOrUpdate(departamento);
        return true;
    }
}
