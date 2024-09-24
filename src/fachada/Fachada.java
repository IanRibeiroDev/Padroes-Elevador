package fachada;

import elevador.Elevador;
import painel.PainelChamadaAndar;
import painel.PainelChamadaElevador;

import java.util.ArrayList;
import java.util.List;

public class Fachada {
    private static Fachada fachada;

    private Elevador elevador;
    private List<PainelChamadaAndar> paineisAndar;
    private PainelChamadaElevador painelElevador;

    private Fachada() {
        elevador = Elevador.getInstance();
        paineisAndar = new ArrayList<PainelChamadaAndar>();

        for(int i = 0; i < elevador.getTotalAndares() + 1; i++) {
            paineisAndar.add(new PainelChamadaAndar(i, this.elevador));
        }

        painelElevador = new PainelChamadaElevador(this.elevador);
    }

    public static Fachada getInstance() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    public void clicarBotaoSubindo(int andar) {
        paineisAndar.get(andar).clicarSubir();
    }

    public void clicarBotaoDescendo(int andar) {
        paineisAndar.get(andar).clicarDescer();
    }

    public void clicarBotaoElevador(int andar) {
        painelElevador.clicar(andar);
    }

    public void mover() {
        this.elevador.mover();
    }
}
