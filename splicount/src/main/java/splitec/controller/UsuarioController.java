package splitec.controller;

import org.apache.coyote.Response;
import org.apache.logging.log4j.message.Message;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;
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
    public ResponseEntity<HttpStatus> login(@RequestBody Usuario model) throws Exception {

        UsuarioService service = new UsuarioService();

        if (!service.verificaModel(model))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        Usuario usuario = service.encontraPorModel(model);
        if (usuario == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        if (!service.autenticarUsuario(model, usuario))
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/upsert")
    public ResponseEntity<String> criarOuAtualizarUsuario(@RequestBody Usuario model) {

        UsuarioService service = new UsuarioService();
        boolean isUpdate = model.getId() != null;

        if (!service.verificaModel(model))
            return new ResponseEntity<>("Parâmetros incorretos", HttpStatus.BAD_REQUEST);
        if (service.encontraPorModel(model) != null)
            return new ResponseEntity<>("Email já cadastrado", HttpStatus.BAD_REQUEST);

        service.criarOuAtualizarUsuario(model);

        if (model.getId() == null)
            return new ResponseEntity<>("Erro ao salvar", HttpStatus.BAD_REQUEST);
        else if (isUpdate)
            return new ResponseEntity<>("Atualizado", HttpStatus.OK);
        else
            return new ResponseEntity<>("Criado", HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable ObjectId id) {

        UsuarioService service = new UsuarioService();

        Usuario usuario = service.encontraPorId(id);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {

        UsuarioService service = new UsuarioService();

        return new ResponseEntity<>(service.listaTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable ObjectId id) {

        UsuarioService service = new UsuarioService();

        if (service.encontraPorId(id) == null)
            return new ResponseEntity<>("Id não cadastrado", HttpStatus.NOT_FOUND);

        service.deletar(id);

        return new ResponseEntity<>("Deletado", HttpStatus.OK);
    }
}