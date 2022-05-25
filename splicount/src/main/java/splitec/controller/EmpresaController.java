package splitec.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import splitec.entities.Departamento;
import splitec.entities.Empresa;
import splitec.service.DepartamentoService;
import splitec.service.EmpresaService;

import java.util.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @PostMapping("/upsert")
    public ResponseEntity<String> criarOuAtualizarEmpresa(@RequestBody Empresa model) {
        EmpresaService service = new EmpresaService();
        boolean isUpdate = model.getId() != null;

        if (!service.verificaModel(model))
            return new ResponseEntity<>("Parâmetros incorretos", HttpStatus.BAD_REQUEST);
        if (service.encontraPorModel(model) != null)
            return new ResponseEntity<>("Empresa com mesmo nome já cadastrada", HttpStatus.BAD_REQUEST);

        service.criarOuAtualizarEmpresa(model);

        if (model.getId() == null)
            return new ResponseEntity<>("Erro ao salvar", HttpStatus.BAD_REQUEST);
        else if (isUpdate)
            return new ResponseEntity<>("Atualizado", HttpStatus.OK);
        else
            return new ResponseEntity<>("Criado", HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Empresa> encontrarEmpresaPorId(@PathVariable ObjectId id) {

        EmpresaService service = new EmpresaService();

        Empresa empresa = service.encontraPorId(id);

        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Empresa>> listarTodosEmpresa() {

        EmpresaService service = new EmpresaService();

        return new ResponseEntity<>(service.listaTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable ObjectId id) {

        EmpresaService service = new EmpresaService();

        if (service.encontraPorId(id) == null)
            return new ResponseEntity<>("Id não cadastrado", HttpStatus.NOT_FOUND);

        service.deletar(id);

        return new ResponseEntity<>("Deletado", HttpStatus.OK);
    }

    @GetMapping("/find/departamentos/{id}")
    public ResponseEntity<String> encontrarDepartamentosEmpresa(@PathVariable ObjectId id) throws JsonProcessingException {

        EmpresaService service = new EmpresaService();
        Empresa empresa = service.encontraPorId(id);

        List<ObjectId> ids = empresa.getDepartamentosIds();
        List<Map> departamentos = new ArrayList<>();
        Map empresaMap = new HashMap<>();
        empresaMap.put("empresa", empresa.getNome());
        empresaMap.put("patrimonio", String.valueOf(empresa.getPatrimonio().getValorTotal()));
        DepartamentoService depService = new DepartamentoService();
        for (int x = 0; x < ids.size(); x++) {
            Departamento serviceResponse = depService.encontraPorId(ids.get(x));
            Map departamento = new HashMap<>();
            departamento.put("nome", serviceResponse.getNome());
            departamento.put("orcamento", String.valueOf(serviceResponse.getOrcamento()));
            departamentos.add(x, departamento);
        }
        empresaMap.put("departamentos", departamentos);

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(empresaMap), HttpStatus.OK);
    }

}
