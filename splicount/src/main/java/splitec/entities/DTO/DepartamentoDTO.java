package splitec.entities.DTO;

import org.bson.types.ObjectId;
import splitec.entities.Departamento;

public class DepartamentoDTO {

    private ObjectId empresaId;
    private Departamento departamento;

    public DepartamentoDTO(ObjectId empresaId, Departamento departamento) {
        this.empresaId = empresaId;
        this.departamento = departamento;
    }

    public ObjectId getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(ObjectId empresaId) {
        this.empresaId = empresaId;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
