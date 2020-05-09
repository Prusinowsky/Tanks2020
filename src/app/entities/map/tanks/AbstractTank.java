package app.entities.map.tanks;

import app.entities.map.MapObject;

public abstract class AbstractTank extends MapObject {

    public Boolean alive = true;
    public Integer angle;
    public Boolean inAnimation;

    public AbstractTank(){
        this.angle = 0;
        this.inAnimation = false;
    }

    public Integer getDirectionX(){
        if(this.angle == 90)
            return 1;
        if(this.angle == 270)
            return -1;
        return 0;
    }

    public Integer getDirectionY(){
        if(this.angle == 180)
            return 1;
        if(this.angle == 0)
            return -1;
        return 0;
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
