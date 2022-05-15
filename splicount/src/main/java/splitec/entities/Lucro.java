package splitec.entities;

import splitec.entities.enums.TipoLucro;
import splitec.entities.interfaces.IValorBase;

public class Lucro {

    private double valor;
    private TipoLucro tipo;
    private String descricao;

    public Lucro() {
    }

    public Lucro(double valor, TipoLucro tipo, String descricao) {
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

    public TipoLucro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLucro tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
