package splitec.service;

import splitec.entities.Departamento;

//casos de usos de departamentos
public class DepartamentoService {

    public boolean validarModel(Departamento departamento) {
        return true;
    }

    public Departamento criarDepartamento(Departamento departamento) {
        //repo.InsertOrUpdate(departamento);
        return departamento;
    }
}
