import app.Container;
import app.engine.Engine;
import app.game.manager.GameStateManager;
import app.game.manager.GameStateManagerInterface;

/**
 * Główna class, ładująca aplikację
 */
public class Bootstrap {

    /**
     * Główna metoda, uruchamiana podczas uruchamiania aplikacji
     * @param args Argumenty z CLI
     */
    public static void main(String[] args)
    {
        GameStateManagerInterface app = new GameStateManager(new Engine());
        app.execute();
    }

}
