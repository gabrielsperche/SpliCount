package splitec.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import splitec.entities.Departamento;
import splitec.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

   @PostMapping("/create")
    public String createDepartment(@RequestBody Departamento departamentoModel) {
        try {
            DepartamentoService service = new DepartamentoService();

            if (service.validarModel(departamentoModel))
                return "erro";

            service.criarDepartamento(departamentoModel);

            return "created";
        } catch (Exception e) {
            return "erro";
        }
    }
}
