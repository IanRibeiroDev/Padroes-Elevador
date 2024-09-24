package painel;

import elevador.Elevador;

public class BotaoDescer {
    private int andar;
    private Elevador elevador;

    public BotaoDescer(int andar, Elevador elevador) {
        this.andar = andar;
        this.elevador = elevador;
    }

    public void clicar() {
        elevador.addAndarDescendo(andar);
    }
}
