package painel;

import elevador.Elevador;

import java.util.ArrayList;
import java.util.List;

public class PainelChamadaElevador {
    private List<BotaoElevador> botoes;

    public PainelChamadaElevador(Elevador elevador) {
        botoes = new ArrayList<BotaoElevador>();

        for(int i = 0; i < elevador.getTotalAndares() + 1; i++) {
            botoes.add(new BotaoElevador(i, elevador));
        }
    }

    public void clicar(int andar) {
        botoes.get(andar).clicar();
    }
}
