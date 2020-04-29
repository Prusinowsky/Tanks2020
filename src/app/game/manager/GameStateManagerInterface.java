package app.game.manager;

/**
 * Menadżer stanów
 */
public interface GameStateManagerInterface {

    /**
     * Inicjalizuje stany
     */
    public void execute();

    /**
     * Zamienń na stan
     * @param toState stan na jaki ma zostać zamienione
     */

    public void changeStateTo(String toState);

    /**
     * Konczy program
     */
    public void exit();

}
