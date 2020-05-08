package app.entities.map.tanks;

import app.entities.map.MapObject;

public abstract class AbstractTank extends MapObject {
    public Integer angle;
    public Boolean inAnimation;

    public AbstractTank(){
        this.angle = 0;
        this.inAnimation = false;
    }

    /**
     * Skieruj w górę
     */
    public void turnUp(){
        this.angle = 0;
    }

    /**
     * Skieruj w prawo
     */
    public void turnRight(){
        this.angle = 90;
    }

    /**
     * Skieruj w dół
     */
    public void turnDown(){
        this.angle = 180;
    }

    /**
     * Skieruj w lewo
     */
    public void turnLeft(){
        this.angle = 270;
    }

}
