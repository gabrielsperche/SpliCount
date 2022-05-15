package splitec.entities;

import org.bson.types.ObjectId;
import splitec.entities.interfaces.IValorBase;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements IValorBase {

    private ObjectId _id;
    private String nome;
    private final Entradas entradas = new Entradas();
    private final Saidas saidas = new Saidas();
    private double orcamento;
    private double meta;
    private double valorTotal;

    @Override
    public void calculaValorTotal() {
        // valorEntradas = entradas.getValorTotal();
        //double valorSaidas = saidas.getValorTotal();

        //valorTotal = valorEntradas - valorSaidas;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Entradas getEntradas() {
        return entradas;
    }

    public Saidas getSaidas() {
        return saidas;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
