package splitec.controller;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import splitec.service.EmpresaService;
import splitec.service.PatrimonioService;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @GetMapping("/getValues/{id}")
    public ResponseEntity<Double> getTodosValoresEmpresa(@PathVariable ObjectId id) {
        PatrimonioService service = new PatrimonioService();
        EmpresaService empresaService = new EmpresaService();

        if (id == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (!empresaService.exiteAlgum(id))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        double valor = service.getValorTotalPorEmpresa(id);

        return new ResponseEntity<>(valor, HttpStatus.OK);
    }
}
