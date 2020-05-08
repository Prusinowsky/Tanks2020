package app.engine;


/**
 * Obiekt odpowiedzialny za sterowanie gry
 */
public class EngineDriver {

    private Engine engine;

    /**
     * Kontruktor domyslny
     * @param engine Slnik gry
     */
    public EngineDriver(Engine engine){
        this.engine = engine;
    }

    /**
     * Porusza gracza w górę
     */
    public void moveUp(){
        engine.getPhysics().getPlayerPhysics().moveUp();
    }

    /**
     * Porusza gracza w dół
     */
    public void moveDown(){
        engine.getPhysics().getPlayerPhysics().moveDown();
    }

    /**
     * Porusza gracza w prawo
     */
    public void moveRight(){
        engine.getPhysics().getPlayerPhysics().moveRight();
    }

    /**
     * Porusza gracza w lewo
     */
    public void moveLeft(){
        engine.getPhysics().getPlayerPhysics().moveLeft();
    }

    /**
     * Strzela
     */
    public void shoot() {
        engine.getPhysics().getPlayerPhysics().shoot();
    }

}
