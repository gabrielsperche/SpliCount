package splitec.entities.DTO;

import org.bson.types.ObjectId;
import splitec.entities.enums.TipoInsercao;

public class ValorDTO {

    private double valor;
    private TipoInsercao tipo;
    private ObjectId departamentoId;

    public ValorDTO(double valor, TipoInsercao tipo, ObjectId departamentoId) {
        this.valor = valor;
        this.tipo = tipo;
        this.departamentoId = departamentoId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoInsercao getTipo() {
        return tipo;
    }

    public void setTipo(TipoInsercao tipo) {
        this.tipo = tipo;
    }

    public ObjectId getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(ObjectId departamentoId) {
        this.departamentoId = departamentoId;
    }
}
