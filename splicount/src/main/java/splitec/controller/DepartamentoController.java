package splitec.controller;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import splitec.entities.Departamento;
import splitec.entities.Usuario;
import splitec.service.DepartamentoService;
import splitec.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

   @PostMapping("/upsert")
    public ResponseEntity<String> criarOuAtualizarDepartamento(@RequestBody Departamento model) {
       DepartamentoService service = new DepartamentoService();
       boolean isUpdate = model.getId() != null;

       if (!service.verificaModel(model))
           return new ResponseEntity<>("Parâmetros incorretos", HttpStatus.BAD_REQUEST);
       if (service.encontraPorModel(model) != null)
           return new ResponseEntity<>("Departamento com mesmo nome já cadastrado", HttpStatus.BAD_REQUEST);

       service.criarOuAtualizarDepartamento(model);

       if (model.getId() == null)
           return new ResponseEntity<>("Erro ao salvar", HttpStatus.BAD_REQUEST);
       else if (isUpdate)
           return new ResponseEntity<>("Atualizado", HttpStatus.OK);
       else
           return new ResponseEntity<>("Criado", HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Departamento> encontrarDepartamentoPorId(@PathVariable ObjectId id) {

        DepartamentoService service = new DepartamentoService();

        Departamento departamento = service.encontraPorId(id);

        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Departamento>> listarTodoDepartamento() {

        DepartamentoService service = new DepartamentoService();

        return new ResponseEntity<>(service.listaTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarDepartamento(@PathVariable ObjectId id) {

        DepartamentoService service = new DepartamentoService();

        if (service.encontraPorId(id) == null)
            return new ResponseEntity<>("Id não cadastrado", HttpStatus.NOT_FOUND);

        service.deletar(id);

        return new ResponseEntity<>("Deletado", HttpStatus.OK);
    }

}
