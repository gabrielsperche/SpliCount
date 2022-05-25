package entities;

public class Nota {
    private String nome;
    private Double valorTotal;
    private Double valorEntrada;
    private Double valorSaida;

    public Nota(){
    }

    public String getNome() {
        return nome;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public Double getValorSaida() {
        return valorSaida;
    }
}
