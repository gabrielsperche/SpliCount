package splitec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import splitec.entities.Departamento;
import splitec.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

   @PostMapping("/upsert")
    public ResponseEntity<String> criarOuAtualizarDepartmento(@RequestBody Departamento model) {
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
}
