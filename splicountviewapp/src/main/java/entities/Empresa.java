package entities;

import java.util.List;

public class Empresa {
    private String empresa;
    private String patrimonio;
    private List<Departamento> departamentos;

    public Empresa() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}