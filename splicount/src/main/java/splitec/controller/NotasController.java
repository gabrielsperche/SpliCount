package splitec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import splitec.entities.DTO.NotaEntrada;
import splitec.entities.DTO.NotaSaida;
import splitec.entities.DTO.NotasLote;
import splitec.entities.Departamento;
import splitec.service.Utils;
import splitec.entities.DTO.ValorDTO;
import splitec.entities.Entrada;
import splitec.entities.Saida;
import splitec.entities.enums.TipoInsercao;
import splitec.service.DepartamentoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @PostMapping("/entrada")
    public ResponseEntity<String> criarEntrada(@RequestBody NotaEntrada entrada) {
        DepartamentoService service = new DepartamentoService();
        Departamento dep = new Departamento();
        dep.setNome(entrada.getNomeDepartamento());
        Departamento depResponse = service.encontraPorModel(dep);
        ValorDTO data = new ValorDTO(entrada.getValor(), TipoInsercao.ENTRADA, depResponse.getId());
        if (!service.adicionaValor(data)) {
            return new ResponseEntity<>("Erro ao adicionar uma nova entrada", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Sucesso", HttpStatus.OK);
        }
    }

    @PostMapping("/saida")
    public ResponseEntity<String> criarSaida(@RequestBody NotaSaida saida) {
        DepartamentoService service = new DepartamentoService();
        Departamento dep = new Departamento();
        dep.setNome(saida.getNomeDepartamento());
        Departamento depResponse = service.encontraPorModel(dep);
        ValorDTO data = new ValorDTO(saida.getValor(), TipoInsercao.SAIDA, depResponse.getId());
        if (!service.adicionaValor(data)) {
            return new ResponseEntity<>("Erro ao adicionar uma nova saída", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Sucesso", HttpStatus.OK);
        }
    }

    @PostMapping("/criarEntradasLote")
    public ResponseEntity<String> criarEntradasLote(@RequestBody NotasLote dataEncoded) throws Exception {
        DepartamentoService service = new DepartamentoService();
        List<Entrada> inputs = Utils.entradaEncodedToList(dataEncoded.getData());
        Map<String, String> errors = new HashMap<>();
        for (Entrada input : inputs) {
            if (!(service
                    .adicionaValor(new ValorDTO(input.getValor(), TipoInsercao.ENTRADA, input.getDepartamentoId())))) {
                errors.put(input.getDepartamentoId().toString(), String.valueOf(input.getValor()));
            }
        }
        return new ResponseEntity<>(errors.toString(), HttpStatus.OK);

    }

    @PostMapping("/criarSaidasLote")
    public ResponseEntity<String> criarSaidasLote(@RequestBody NotasLote dataEncoded) throws Exception {
        DepartamentoService service = new DepartamentoService();
        List<Saida> inputs = Utils.saidaEncodedToList(dataEncoded.getData());
        Map<String, String> errors = new HashMap<>();
        for (Saida input : inputs) {
            if (!(service
                    .adicionaValor(new ValorDTO(input.getValor(), TipoInsercao.SAIDA, input.getDepartamentoId())))) {
                errors.put(input.getDepartamentoId().toString(), String.valueOf(input.getValor()));
            }
        }
        return new ResponseEntity<>(errors.toString(), HttpStatus.OK);

    }

}
