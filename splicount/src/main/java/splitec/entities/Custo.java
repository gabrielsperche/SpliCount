package splitec.entities;

import splitec.entities.enums.TipoCusto;

public class Custo {

    private double valor;
    private TipoCusto tipo;
    private String descricao;

    public Custo() {
    }

    public Custo(double valor, TipoCusto tipo, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoCusto getTipo() {
        return tipo;
    }

    public void setTipo(TipoCusto tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
