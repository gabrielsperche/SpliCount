package splitec.controller;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import splitec.entities.Usuario;
import splitec.service.UsuarioService;

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
            service.verifyUser(user);
            return "foi";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @PostMapping("/create")
    public String criarUsuario(@RequestBody Usuario usuario) {
        UsuarioService service = new UsuarioService();
        service.createUser(usuario);
        return "foi";
    }

    @GetMapping("/find")
    public Usuario getUsuario(@RequestBody ObjectId id) {
        UsuarioService service = new UsuarioService();
        return service.getById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}