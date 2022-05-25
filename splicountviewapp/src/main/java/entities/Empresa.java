package entities;

import java.util.List;

public class Empresa {
    private String nome;
    private String patrimonio;
    private List<Departamento> departamentos;

    public Empresa(String nome, String patrimonio, List<Departamento> departamentos) {
        this.nome = nome;
        this.patrimonio = patrimonio;
        this.departamentos = departamentos;
    }

    public String getNome() {
        return nome;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}