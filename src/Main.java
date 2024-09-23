import elevador.Elevador;

public class Main {
    public static void main(String[] args) {
        Elevador e = Elevador.getInstance(10);

        e.addAndarSubindo(4);
        e.addAndarSubindo(6);
        e.addAndarSubindo(9);

        e.addAndarDescendo(4);
        e.addAndarDescendo(2);
        e.addAndarDescendo(10);

        e.mover();
    }
}