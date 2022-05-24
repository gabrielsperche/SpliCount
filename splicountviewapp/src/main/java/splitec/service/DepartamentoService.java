package splitec.service;

import entities.MessageResponse;
import splitec.repository.DepartamentoRepository;
import splitec.repository.UsuarioRepository;

public class DepartamentoService extends DepartamentoRepository {
    public static MessageResponse createDepartamento(String nome, Double orcamento) {
        return criaDepartamento(nome, orcamento);
    }
}
