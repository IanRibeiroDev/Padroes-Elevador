package utilidades;

public class Utils {
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            //Nunca entra
        }
    }

    private Utils() {}
}
