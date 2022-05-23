package splitec.controller;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import splitec.entities.DTO.DepartamentoDTO;
import splitec.entities.DTO.DepartamentoValor;
import splitec.entities.DTO.ValorDTO;
import splitec.entities.Departamento;
import splitec.service.DepartamentoService;
import splitec.service.EmpresaService;
import splitec.service.PatrimonioService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @PostMapping("/upsert")
    public ResponseEntity<String> criarOuAtualizarDepartamento(@RequestBody DepartamentoDTO model) {
       DepartamentoService service = new DepartamentoService();
       EmpresaService empresaService = new EmpresaService();

       boolean isUpdate = model.getDepartamento().getId() != null;

       if (!empresaService.exiteAlgum(model.getEmpresaId()))
           return new ResponseEntity<>("Empresa não encontrada", HttpStatus.NOT_FOUND);
       if (!service.verificaModel(model.getDepartamento()))
           return new ResponseEntity<>("Parâmetros incorretos", HttpStatus.BAD_REQUEST);
       if (service.encontraPorModel(model.getDepartamento()) != null)
           return new ResponseEntity<>("Departamento com mesmo nome já cadastrado", HttpStatus.BAD_REQUEST);

       service.criarOuAtualizarDepartamento(model.getEmpresaId(), model.getDepartamento());

       if (model.getDepartamento().getId() == null)
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

    @GetMapping("/getValues/{idEmpresa}")
    public ResponseEntity<List<DepartamentoValor>> getTodosValoresDepartamentos(@PathVariable ObjectId idEmpresa) {
        DepartamentoService service = new DepartamentoService();
        EmpresaService empresaService = new EmpresaService();

        if (idEmpresa == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (empresaService.exiteAlgum(idEmpresa))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        List<DepartamentoValor> valores = service.getValorTotalPorEmpresa(idEmpresa);

        return new ResponseEntity<>(valores, HttpStatus.OK);
    }

    @PostMapping("/addValor")
    public ResponseEntity<HttpStatus> adicionaValor(@RequestBody ValorDTO model) {
        DepartamentoService service = new DepartamentoService();

        if (model.getDepartamentoId() == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        Departamento departamento = service.encontraPorId(model.getDepartamentoId());

        if (departamento == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        if (service.adicionaValor(model))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
