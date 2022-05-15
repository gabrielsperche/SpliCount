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

    @PostMapping("/create")
    public String criarUsuario(@RequestBody Usuario usuario) {
        UsuarioService service = new UsuarioService();
        service.criarUsuario(usuario);
        return "Sucess";
    }

    @GetMapping("/find/{id}")
    public Usuario encontrarUsuarioPorId(@PathVariable ObjectId id) {
        UsuarioService service = new UsuarioService();
        Usuario u = service.encontraPorId(id);
        return u;
    }

    @GetMapping("/findall")
    public List<Usuario> listarTodosUsuarios() {
        UsuarioService service = new UsuarioService();
        List<Usuario> usuarioList = service.listaTodos();
        return usuarioList;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}