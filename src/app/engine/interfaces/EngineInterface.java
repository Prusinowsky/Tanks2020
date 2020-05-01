package app.engine.interfaces;

import app.engine.EngineDriver;
import app.engine.EnginePhysics;
import app.engine.EngineRender;

/**
 * Interferjs silnika gry
 */
public interface EngineInterface {

    /**
     * Metoda odpowiadająca za start gry
     */
    public void startGame();

    /**
     * Metoda odpowiadająca za pausowanie gry
     */
    public void pauseGame();

    /**
     * Metoda odpowiadająca za pausowanie gry
     */
    public void resumeGame();

    /**
     * Metoda odpowiadająca za koniec gry
     */
    public void endGame();

    /**
     * Meotda zwraca sterownik silnika
     * @return Sterownik silnika
     */
    public EngineDriver getDriver();

    /**
     * Metoda zwraca odbiekt fizyki silnika
     * @return Fizyka silnika
     */
    public EnginePhysics getPhysics();

    /**
     * Metoda zwraca obiekt odpowiedzlany za renderowanie silnika
     * @return Obiekt renderujący obraz gry
     */
    public EngineRender getRender();
}
