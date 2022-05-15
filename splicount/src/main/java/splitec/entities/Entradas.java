package splitec.entities;

import java.util.ArrayList;
import java.util.List;

public class Entradas extends ValoresBase {

    private final List<Lucro> lucros = new ArrayList<>();

    public Entradas() {
    }

    public void addLucro(Lucro lucro) {
        lucros.add(lucro);
    }

    public List<Lucro> getLucros() {
        return lucros;
    }
}
