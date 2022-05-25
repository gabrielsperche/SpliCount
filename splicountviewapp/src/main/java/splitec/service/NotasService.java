package splitec.service;

import entities.MessageResponse;
import splitec.repository.NotasRepository;

public class NotasService extends NotasRepository {
    public static MessageResponse createNota(String nome, String tipo, Double valor) {
        return criaNota(nome, tipo, valor);
    }
}
