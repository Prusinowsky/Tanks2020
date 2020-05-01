package app.engine;

import app.engine.animations.MoveTankAnimation;
import app.entities.map.objects.Bullet;



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
        engine.getPhysics().getPlayerTankPhysics().moveUp();
    }

    /**
     * Porusza gracza w dół
     */
    public void moveDown(){
        engine.getPhysics().getPlayerTankPhysics().moveDown();
    }

    /**
     * Porusza gracza w prawo
     */
    public void moveRight(){
        engine.getPhysics().getPlayerTankPhysics().moveRight();
    }

    /**
     * Porusza gracza w lewo
     */
    public void moveLeft(){
        engine.getPhysics().getPlayerTankPhysics().moveLeft();
    }

    /**
     * Strzela
     */
    public void shoot() {
        engine.getPhysics().getPlayerTankPhysics().shoot();
    }

}
