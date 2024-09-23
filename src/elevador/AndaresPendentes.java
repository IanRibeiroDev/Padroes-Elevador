package elevador;

import java.util.ArrayList;
import java.util.List;

public class AndaresPendentes {
    private Elevador elevador;
    private List<Integer> andaresPendentes;

    public AndaresPendentes(Elevador elevador) {
        this.elevador = elevador;
        andaresPendentes = new ArrayList<>();
    }

    public void addAndar(int andar) throws Exception {
        if(andar <= elevador.getTotalAndares() && andar >= 0 && !andaresPendentes.contains(andar)) {
            andaresPendentes.add(andar);
        } else {
            throw new Exception("Operação nao permitida!");
        }
    }

    public void removeAndar(int andar) throws Exception {
        if(andar <= elevador.getTotalAndares() && andar >= 0 && andaresPendentes.contains(andar)) {
            andaresPendentes.remove((Integer) andar);
        } else {
            throw new Exception("Operação nao permitida!");
        }
    }

    public List<Integer> getAndaresPendentes() {
        return List.copyOf(andaresPendentes);
    }

    @Override
    public String toString() {
        String s = "";
        for (int andar : andaresPendentes) {
            s += andar + " ";
        }
        return s;
    }
}
