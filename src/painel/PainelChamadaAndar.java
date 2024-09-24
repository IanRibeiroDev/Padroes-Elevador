package painel;

import elevador.Elevador;

public class PainelChamadaAndar {
    private BotaoSubir botaoSubir;
    private BotaoDescer botaoDescer;

    public PainelChamadaAndar(int andar, Elevador elevador) {
        if(elevador.getTotalAndares() != andar) {
            botaoSubir = new BotaoSubir(andar, elevador);
        }

        if(andar != 0) {
            botaoDescer = new BotaoDescer(andar, elevador);
        }
    }

    public void clicarSubir() {
        if(botaoSubir != null) {
            botaoSubir.clicar();
        }
    }

    public void clicarDescer() {
        if(botaoDescer != null) {
            botaoDescer.clicar();
        }
    }
}
