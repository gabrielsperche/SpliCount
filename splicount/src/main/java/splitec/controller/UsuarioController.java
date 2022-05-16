package splitec.controller;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import splitec.entities.Usuario;
import splitec.service.UsuarioService;

import java.util.List;

/**
 * @author gabrielsperche
 */

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @PostMapping("/auth")
    public String login(@RequestBody Usuario user) throws Exception {
        try {
            UsuarioService service = new UsuarioService();
            service.verificaUsuario(user);
            return "foi";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @PostMapping("/upsert")
    public String criarOuAtualizarUsuario(@RequestBody Usuario usuario) {
        UsuarioService service = new UsuarioService();
        service.criarOuAtualizarUsuario(usuario);
        return "Sucess";
    }

    @GetMapping("/find/{id}")
    public Usuario encontrarUsuarioPorId(@PathVariable ObjectId id) {
        UsuarioService service = new UsuarioService();
        return service.encontraPorId(id);
    }

    @GetMapping("/findall")
    public List<Usuario> listarTodosUsuarios() {
        UsuarioService service = new UsuarioService();
        return service.listaTodos();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable ObjectId id) {
        UsuarioService service = new UsuarioService();
        service.deletar(id);
        return "Sucesso";
    }
}