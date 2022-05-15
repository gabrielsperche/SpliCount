package splitec.entities;

import java.util.ArrayList;
import java.util.List;

public class Saidas extends ValoresBase {

    private final List<Custo> custos = new ArrayList<>();

    public Saidas() {
    }

    public void addCusto(Custo custo){
        custos.add(custo);
    }

    public List<Custo> getLucros() {
        return custos;
    }
}
