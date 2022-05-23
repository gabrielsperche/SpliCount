package splitec.service;

import entities.MessageResponse;
import splitec.repository.EmpresaRepository;

public class EmpresaService extends EmpresaRepository {
    public static MessageResponse createEmpresa(String nome, String cnpj) {
        return criaEmpresa(nome, cnpj);
    }

    public static void main(String args[]) throws Exception {
        createEmpresa("Teste", "123213123123");
    }
}
