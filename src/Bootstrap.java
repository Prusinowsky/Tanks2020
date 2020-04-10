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
        Config config = Config.getInstance();
        config.load();

        GameWindow app = new GameWindow();
        app.open();
    }

}
