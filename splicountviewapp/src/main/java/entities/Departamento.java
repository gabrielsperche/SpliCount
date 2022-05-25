package entities;

public class Departamento {
    private String nome;
    private String orcamento;

    public Departamento(String nome, String orcamento) {
        this.nome = nome;
        this.orcamento = orcamento;
    }

    public Departamento() {
    }

    public String getNome() {
        return nome;
    }

    public String getOrcamento() {
        return orcamento;
    }
}
