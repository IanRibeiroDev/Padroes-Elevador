package painel;

import elevador.Elevador;

public class BotaoElevador {
    private int andar;
    private Elevador elevador;

    public BotaoElevador(int andar, Elevador elevador) {
        this.andar = andar;
        this.elevador = elevador;
    }

    public void clicar() {
        if(elevador.getAndarAtual() < andar) {
            elevador.addAndarSubindo(andar);
        } else {
            elevador.addAndarDescendo(andar);
        }
    }
}
