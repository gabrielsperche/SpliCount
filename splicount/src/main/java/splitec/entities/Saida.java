package splitec.entities;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Saida {
@Id
    private ObjectId _id;
    private double valor;
    private ObjectId departamentoId;

    public Saida(ObjectId id, double valor, ObjectId departamentoId) {
        this._id = id;
        this.valor = valor;
        this.departamentoId = departamentoId;
    }

    public Saida(double valor, ObjectId departamentoId) {
        this.valor = valor;
        this.departamentoId = departamentoId;
    }

    public Saida() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ObjectId getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(ObjectId departamentoId) {
        this.departamentoId = departamentoId;
    }
}
