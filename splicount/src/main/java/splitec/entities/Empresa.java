package splitec.entities;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("Empresa")
public class Empresa {

    @Id
    private ObjectId _id;
    private String nome;

    public Empresa(ObjectId _id, String nome) {
        this._id = _id;
        this.nome = nome;
    }

    public Empresa() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
