package app.engine.animations;

import app.entities.map.tanks.AbstractTank;

import java.util.Timer;

public class MoveTankAnimation extends AbstractAnimation {

    private AbstractTank tank;
    private Integer x, y = 0;
    private Integer counter = 1;

    public MoveTankAnimation(AbstractTank tank, Integer x, Integer y){
        this.timer = new Timer();
        this.tank = tank;
        this.tank.inAnimation = true;
        this.x = x;
        this.y = y;
        setAngle();
        this.timer.schedule(this, 0, 8);
    }

    private void setAngle(){
        if(y < 0)
            tank.angle = 0;
        if(x > 0)
            tank.angle = 90;
        if(y > 0)
            tank.angle = 180;
        if(x < 0)
            tank.angle = 270;
    }

    @Override
    public void run() {
        if(counter++ >= 16) {
            tank.inAnimation = false;
            timer.cancel();
            timer.purge();
        }
        tank.positionX += x/16;
        tank.positionY += y/16;
    }

}
