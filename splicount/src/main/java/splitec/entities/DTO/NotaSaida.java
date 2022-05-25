package splitec.entities.DTO;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("NotaSaida")
public class NotaSaida {

    @Id
    private ObjectId _id;
    private double valor;
    private String nomeDepartamento;

    public NotaSaida(ObjectId id, double valor, ObjectId departamentoId) {
        this._id = id;
        this.valor = valor;
        this.nomeDepartamento = nomeDepartamento;
    }

    public NotaSaida(double valor, ObjectId departamentoId) {
        this.valor = valor;
        this.nomeDepartamento = nomeDepartamento;
    }
    public NotaSaida(){
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

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
}
