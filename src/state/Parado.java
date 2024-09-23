package state;

import elevador.Elevador;
import utilidades.Utils;

public class Parado implements State {
    Elevador elevador;

    public Parado(Elevador elevador) {
        this.elevador = elevador;
        abrirPorta();
    }

    public void gerenciarMovimento() {
        printVisor();

        if(elevador.getFilaAndares().isEmpty()) {
            return;
        }

        if(elevador.estavaDescendo()) {
            if(elevador.getAndarAtual() != 0) {
                elevador.changeState(new Descendo(elevador));
                elevador.mover();

            } else {
                elevador.changeState(new Subindo(elevador));
                elevador.mover();
            }

        } else {
            if(elevador.getAndarAtual() != elevador.getTotalAndares()) {
                elevador.changeState(new Subindo(elevador));
                elevador.mover();

            } else {
                elevador.changeState(new Descendo(elevador));
                elevador.mover();
            }
        }
    }

    public void printVisor() {
        String s = "+------------------------+\n| ";
        s += elevador.getFilaAndares();
        s += "|\n+------------------------+\n";
        s += "| Atual [ " + elevador.getAndarAtual() + " ] |\n";
        s += "+------------------------+\n";

        System.out.println(s);

        Utils.sleep(3000);
    }

    public void abrirPorta() {
        System.out.println("Porta abrindo...");
        elevador.abrirPorta();

        Utils.sleep(1000);

        System.out.println("Porta aberta!\n");

        Utils.sleep(1000);
    }
}
