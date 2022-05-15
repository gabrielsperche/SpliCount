package splitec.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import splitec.entities.Departamento;
import splitec.entities.User;
import splitec.service.GerirDepartamentoService;
import splitec.service.Service;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController extends Service {

   @PostMapping("/create")
    public String createDepartment(@RequestBody Departamento departamentoModel) {
        try {
            GerirDepartamentoService service = new GerirDepartamentoService();

            if (service.validarModel(departamentoModel))
                return "erro";

            service.criarDepartamento(departamentoModel);

            return "created";
        } catch (Exception e) {
            return "erro";
        }
    }
}
