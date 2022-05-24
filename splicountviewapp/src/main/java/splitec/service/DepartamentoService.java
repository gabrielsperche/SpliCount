package splitec.service;

import entities.MessageResponse;
import splitec.repository.DepartamentoRepository;
import splitec.repository.UsuarioRepository;

public class DepartamentoService extends DepartamentoRepository {
    public static MessageResponse createDepartamento(String nome, Double orcamento, String empresaId) {
        return criaDepartamento(nome, orcamento, empresaId);
    }

    public static void main(String args[]) throws Exception {
        createDepartamento("RH", 100.50, "628ad80d650e831dc853ba23");
    }
}
