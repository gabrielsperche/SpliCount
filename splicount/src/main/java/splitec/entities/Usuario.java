package splitec.entities;;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

/**
 * @author gabrielsperche
 */
@Entity("Usuario")
public class Usuario {
    @Id
    private ObjectId _id;

    private String nome;
    private String senha;

    public Usuario(ObjectId id, String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this._id = id;
    }

    public Usuario() {
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public ObjectId getId() {
        return this._id;
    }
}
