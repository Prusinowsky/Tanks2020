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
     * Zmaina stanu
     */
    public void changeStateTo(String toState);

    /**
     * Konczy program
     */
    public void exit();

}
