package splitec.service;

import entities.MessageResponse;
import entities.Nota;
import splitec.repository.DepartamentoRepository;
import splitec.repository.UsuarioRepository;

import java.util.List;

public class DepartamentoService extends DepartamentoRepository {
    public static MessageResponse createDepartamento(String nome, Double orcamento) {
        return criaDepartamento(nome, orcamento);
    }

    public static List<Nota> getNotas() {
        return buscarNotas();
    }
}
