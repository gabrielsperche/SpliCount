package splitec.entities;

import com.mongodb.DBRef;
import org.bson.types.ObjectId;
import splitec.entities.enums.TipoInsercao;

import java.util.List;

public class Entrada {

    private ObjectId _id;
    private double valor;
    private ObjectId departamentoId;

    public Entrada(ObjectId id, double valor, ObjectId departamentoId) {
        this._id = id;
        this.valor = valor;
        this.departamentoId = departamentoId;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
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
