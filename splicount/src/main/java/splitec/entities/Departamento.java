package splitec.entities;

import com.mongodb.DBRef;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;
import splitec.entities.interfaces.IValorBase;

import java.util.ArrayList;
import java.util.List;

@Entity("Departamento")
public class Departamento implements IValorBase {
    @Id
    private ObjectId _id;
    private String nome;
    private final List<Entrada> entradas = new ArrayList<Entrada>();
    private final List<Saida> saidas = new ArrayList<Saida>();
    private double orcamento;
    private double valorTotal;
    private double valorTotalEntradas;
    private double valorTotalSaidas;

    @Override
    public void calculaValorTotal() {
        calculaTotalEntradas();
        calculaTotalSaidas();
        this.valorTotal =  valorTotalEntradas - valorTotalSaidas;
    }

    public void calculaTotalEntradas() {
        double somaEntrada = 0;
        for (Entrada entrada : entradas) {
            somaEntrada += entrada.getValor();
        }

        valorTotalEntradas = somaEntrada;
    }

    public void calculaTotalSaidas() {
        double somaSaida = 0;
        for (Saida saida : saidas) {
            somaSaida += saida.getValor();
        }

        valorTotalSaidas = somaSaida;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    private void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Saida> getSaidas() {
        return saidas;
    }

    public double getValorTotalEntradas() {
        return valorTotalEntradas;
    }

    public double getValorTotalSaidas() {
        return valorTotalSaidas;
    }

    public void addEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void addEntrada(List<Entrada> entradas) {
        this.entradas.addAll(entradas);
    }

    public void removeEntrada(ObjectId id){
        int size = entradas.size();
        for (int i = 0; i < size; i++) {
            if (entradas.get(i).getDepartamentoId() == id)
                entradas.remove(i);
        }
    }

    public void addSaida(Saida saida) {
        saidas.add(saida);
    }

    public void addSaida(List<Saida> saida) {
        this.saidas.addAll(saida);
    }

    public void removeSaida(ObjectId id){
        int size = saidas.size();
        for (int i = 0; i < size; i++) {
            if (saidas.get(i).getDepartamentoId() == id)
                saidas.remove(i);
        }
    }
}
