package splitec.entities.DTO;

public class DepartamentoValor {

    private String nome;
    private double valorTotal;
    private double valorEntrada;
    private double valorSaida;

    public DepartamentoValor(String nome, double valorTotal, double valorEntrada, double valorSaida) {
        this.nome = nome;
        this.valorTotal = valorTotal;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }
}
