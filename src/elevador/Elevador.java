package elevador;

import state.Descendo;
import state.Parado;
import state.State;
import state.Subindo;

import java.util.List;

public class Elevador {
    // Instância única do Singleton
    private static Elevador elevador;

    private int totalAndares;
    private int andarAtual;

    //State subindo, parado ou descendo
    private State estadoAtual;
    private State estadoAnterior;

    //Porta aberta ou fechada
    private boolean portaAberta;

    //Lista de andares pendentes pra subir
    private AndaresPendentes andaresSubindo;

    //Lista de andares pendentes pra descer
    private AndaresPendentes andaresDescendo;

    //Lista com todas as requisições na ordem de chamada
    private FilaPendentes filaAndares;

    private Elevador(int totalAndares) {
        this.totalAndares = totalAndares;
        this.andarAtual = 0;

        this.estadoAtual = new Parado(this);

        this.andaresSubindo = new AndaresPendentes(this);
        this.andaresDescendo = new AndaresPendentes(this);
        this.filaAndares = new FilaPendentes(this);
    }

    public static Elevador getInstance() {
        if (elevador == null) {
            elevador = new Elevador(10);
        }
        return elevador;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int novoAndarAtual) {
        this.andarAtual = novoAndarAtual;
    }

    public void mover() {
        estadoAtual.gerenciarMovimento();
    }

    public void changeState(State state) {
        this.estadoAnterior = this.estadoAtual;
        this.estadoAtual = state;
    }

    public void addAndarSubindo(int andar) {
        try {
            andaresSubindo.addAndar(andar);
            filaAndares.addAndarSubindo(andar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeAndarSubindo(int andar) {
        try {
            andaresSubindo.removeAndar(andar);
            filaAndares.removeAndarSubindo(andar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAndarDescendo(int andar) {
        try {
            andaresDescendo.addAndar(andar);
            filaAndares.addAndarDescendo(andar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeAndarDescendo(int andar) {
        try {
            andaresDescendo.removeAndar(andar);
            filaAndares.removeAndarDescendo(andar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> getAndaresSubindo() {
        return andaresSubindo.getAndaresPendentes();
    }

    public List<Integer> getAndaresDescendo() {
        return andaresDescendo.getAndaresPendentes();
    }

    public String getFilaAndares() {
        return filaAndares.toString();
    }

    public void abrirPorta() {
        this.portaAberta = true;
    }

    public void fecharPorta() {
        this.portaAberta = false;
    }

    public boolean estavaSubindo() {
        return estadoAnterior instanceof Subindo;
    }

    public boolean estavaDescendo() {
        return estadoAnterior instanceof Descendo;
    }
}
