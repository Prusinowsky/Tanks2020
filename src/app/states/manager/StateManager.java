package app.states.manager;

import app.Container;

/**
 * Menadżer stanów
 */
public class StateManager implements StateManagerInterface {


    private Container container;

    /**
     * Konstruktor domyslny
     * @param container
     */
    public StateManager(Container container){
        this.container = container;
    }

    /**
     * Metoda uruchamiajaca menagera stanow
     */
    @Override
    public void execute() {

    }

    /**
     * Metoda konczaca działanie mendadżera stanów
     */
    @Override
    public void exit() {

    }
}
