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
     * Zmaina stanu
     */
    public void changeStateTo(String toState);

    /**
     * Konczy program
     */
    public void exit();

}
