import app.Container;
import app.states.manager.StateManager;
import app.states.manager.StateManagerInterface;

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

        StateManagerInterface app = new StateManager(Container.getInstance());
        app.execute();

    }

}
