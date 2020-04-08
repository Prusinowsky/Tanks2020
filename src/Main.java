import app.config.Config;
import app.loaders.map.MapLoader;
import app.loaders.texture.TextureLoader;
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

        MapLoader map = new MapLoader();
        map.load();

        MainWindow app = new MainWindow();
        app.open();
    }

}
