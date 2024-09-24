package painel;

import elevador.Elevador;

public class BotaoSubir {
    private int andar;
    private Elevador elevador;

    public BotaoSubir(int andar, Elevador elevador) {
        this.andar = andar;
        this.elevador = elevador;
    }

    public void clicar() {
        elevador.addAndarSubindo(andar);
    }
}
