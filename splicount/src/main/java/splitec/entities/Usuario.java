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
    private String email;
    private String senha;
    private String empresa;

    public Usuario(ObjectId id, String nome, String email, String senha, String idEmpresa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this._id = id;
        this.empresa = idEmpresa;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
