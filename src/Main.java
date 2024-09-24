import elevador.Elevador;
import fachada.Fachada;

public class Main {
    public static void main(String[] args) {
        Fachada controlador = Fachada.getInstance();

        controlador.clicarBotaoSubindo(4);
        controlador.clicarBotaoSubindo(6);
        controlador.clicarBotaoSubindo(9);

        controlador.clicarBotaoDescendo(4);
        controlador.clicarBotaoDescendo(7);
        controlador.clicarBotaoDescendo(10);

        controlador.mover();

        controlador.clicarBotaoElevador(1);
        controlador.clicarBotaoElevador(6);
        controlador.clicarBotaoElevador(8);

        controlador.clicarBotaoSubindo(6);
        controlador.clicarBotaoSubindo(8);
        controlador.clicarBotaoDescendo(6);

        controlador.mover();
    }
}