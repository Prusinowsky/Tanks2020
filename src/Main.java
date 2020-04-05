import app.config.Config;
import app.windows.MainWindow;

/**
 * Główna class, ładująca aplikację
 */
public class Main {

    /**
     * Główna metoda, uruchamiana podczas uruchamiania aplikacji
     * @param args
     */
    public static void main(String[] args)
    {
        Config config = Config.getInstance();
        config.load();
        MainWindow app = new MainWindow();
        app.open();
    }

}
