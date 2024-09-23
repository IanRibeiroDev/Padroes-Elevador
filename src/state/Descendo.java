package state;

import elevador.Elevador;
import utilidades.Utils;

public class Descendo implements State {
    Elevador elevador;

    public Descendo(Elevador elevador) {
        this.elevador = elevador;
        fecharPorta();
    }

    public void gerenciarMovimento() {
        printVisor();

        if(elevador.getAndaresDescendo().contains(elevador.getAndarAtual())) {
            elevador.removeAndarDescendo(elevador.getAndarAtual());
            elevador.changeState(new Parado(elevador));
            elevador.mover();

        } else if(elevador.getAndarAtual() == 0) {
            if(elevador.getAndaresSubindo().contains(elevador.getAndarAtual())) {
                elevador.removeAndarSubindo(elevador.getAndarAtual());
            }
            elevador.changeState(new Parado(elevador));
            elevador.mover();

        } else {
            elevador.setAndarAtual(elevador.getAndarAtual() - 1);
            gerenciarMovimento();
        }
    }

    public void printVisor() {
        String s = "+------------------------+\n| ";
        s += elevador.getFilaAndares();
        s += "|\n+------------------------+\n";
        s += "| Descendo [ " + elevador.getAndarAtual() + " ] |\n";
        s += "+------------------------+\n";

        System.out.println(s);

        Utils.sleep(2000);
    }

    public void fecharPorta() {
        System.out.println("Porta fechando...");
        elevador.fecharPorta();

        Utils.sleep(1000);

        System.out.println("Porta fechada!\n");

        Utils.sleep(1000);
    }
}
