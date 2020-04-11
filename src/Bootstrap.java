import app.Container;
import app.config.Config;
import app.windows.GameWindow;

/**
 * Główna class, ładująca aplikację
 */
public class Bootstrap {

    /**
     * Główna metoda, uruchamiana podczas uruchamiania aplikacji
     * @param args
     */
    public static void main(String[] args)
    {
        Container.getInstance();

        GameWindow app = new GameWindow();
        app.open();
    }

}
