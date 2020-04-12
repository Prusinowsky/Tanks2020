package app.states.manager;

/**
 * Menadżer stanów
 */
public interface StateManagerInterface {

    /**
     * Inicjalizuje stany
     */
    public void execute();

    /**
     * Konczy program
     */
    public void exit();

}
