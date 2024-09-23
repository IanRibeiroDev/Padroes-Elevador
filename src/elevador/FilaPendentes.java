package elevador;

import java.util.ArrayList;
import java.util.List;

public class FilaPendentes {
    private List<String> filaPendentes;

    public FilaPendentes(Elevador elevador) {
        filaPendentes = new ArrayList<>();
    }

    public void addAndarSubindo(int andar) {
        filaPendentes.add("S" + andar);
    }

    public void removeAndarSubindo(int andar) {
        filaPendentes.remove("S" + andar);
    }

    public void addAndarDescendo(int andar) {
        filaPendentes.add("D" + andar);
    }

    public void removeAndarDescendo(int andar) {
        filaPendentes.remove("D" + andar);
    }

    @Override
    public String toString() {
        String s = "";
        for (String chamada : filaPendentes) {
            s += chamada + " ";
        }
        return s;
    }
}
