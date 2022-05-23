package splitec.entities;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

import java.util.List;

@Entity("Patrimonio")
public class Patrimonio {

    @Id
    private ObjectId _id;
    private double valorTotal;

    public Patrimonio(ObjectId _id, double valorTotal) {
        this._id = _id;
        this.valorTotal = valorTotal;
    }

    public Patrimonio() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calculaValorTotal(List<Departamento> departamentos) {
        double valor = 0;
        if (departamentos == null)
            return;
        for (Departamento dpt : departamentos) {
            dpt.calculaValorTotal();
            valor += dpt.getValorTotal();
        }
        valorTotal = valor;
    }
}
