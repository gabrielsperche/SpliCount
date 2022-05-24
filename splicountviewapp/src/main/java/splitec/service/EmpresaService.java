package splitec.service;

import entities.MessageResponse;
import splitec.repository.EmpresaRepository;

public class EmpresaService extends EmpresaRepository {
    public static MessageResponse createEmpresa(String nome, String orcamento) {
        return criaEmpresa(nome, orcamento);
    }
}
