package splitec.service;

import org.bson.types.ObjectId;
import splitec.entities.Departamento;
import splitec.entities.Empresa;
import splitec.entities.Patrimonio;
import splitec.repository.PatrimonioRepository;

import java.util.List;

public class PatrimonioService {

    PatrimonioRepository _repository;
    DepartamentoService departamentoService;
    EmpresaService empresaService;

    public PatrimonioService() {
        departamentoService = new DepartamentoService();
        empresaService = new EmpresaService();
        _repository = new PatrimonioRepository();
    }

    public double getValorTotalPorEmpresa(ObjectId empresaId) {
        Empresa empresa = empresaService.encontraPorId(empresaId);

        Patrimonio patrimonio = empresa.getPatrimonio();

        List<Departamento> departamentoList = departamentoService.encontraPorId(empresa.getDepartamentosIds());

        patrimonio.calculaValorTotal(departamentoList);
        _repository.saveOrUpdate(patrimonio);
        return patrimonio.getValorTotal();
    }
}
