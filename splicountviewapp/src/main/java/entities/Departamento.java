package entities;

public class Departamento {
    private String nome;
    private Double orcamento;

    public Departamento(String nome, Double orcamento) {
        this.nome = nome;
        this.orcamento = orcamento;
    }

    public String getNome() {
        return nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }
}
