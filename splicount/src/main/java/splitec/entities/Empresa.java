package splitec.entities;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Entity("Empresa")
public class Empresa {

    @Id
    private ObjectId _id;
    private String nome;
    private Patrimonio patrimonio = new Patrimonio();
    private List<ObjectId> departamentosIds = new ArrayList<>();

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

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public List<ObjectId> getDepartamentosIds() {
        return departamentosIds;
    }

    public void addDepartamento(ObjectId id) {
        departamentosIds.add(id);
    }

    public void removeDepartamento(ObjectId id){
        departamentosIds.remove(id);
    }
}
