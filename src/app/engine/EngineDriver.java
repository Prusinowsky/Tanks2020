package app.engine;

import app.engine.interfaces.EngineInterface;
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

    public void moveUp(){
        if(engine.player.getCoordinateY()-1>=0 && engine.player.getCoordinateY()-1 < engine.map.height)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY()-1] == null){
                engine.player.positionY -= 32;
                engine.player.angle = 0;
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY() - 1].isOpaque()) {
                engine.player.positionY -= 32;
                engine.player.angle = 0;
            }
            else engine.player.angle = 0;
    }

    public void moveDown(){
        if(engine.player.getCoordinateY()+1>=0 && engine.player.getCoordinateY()+1 < engine.map.height)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY()+1] == null){
                engine.player.positionY += 32;
                engine.player.angle = 180;
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY() + 1].isOpaque()) {
                engine.player.positionY += 32;
                engine.player.angle = 180;
            }
            else engine.player.angle = 180;
    }

    public void moveRight(){
        if(engine.player.getCoordinateX()+1>=0 && engine.player.getCoordinateX()+1 < engine.map.width)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()+1][engine.player.getCoordinateY()] == null){
                engine.player.positionX += 32;
                engine.player.angle = 90;
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX() + 1][engine.player.getCoordinateY()].isOpaque()) {
                engine.player.positionX += 32;
                engine.player.angle = 90;
            }
            else engine.player.angle = 90;
    }

    public void moveLeft(){
        if(engine.player.getCoordinateX()-1>=0 && engine.player.getCoordinateX()-1 < engine.map.width)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()-1][engine.player.getCoordinateY()] == null){
                engine.player.positionX -= 32;
                engine.player.angle = 270;
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX() - 1][engine.player.getCoordinateY()].isOpaque()) {
                engine.player.positionX -= 32;
                engine.player.angle = 270;
            }
            else engine.player.angle = 270;
    }

    public void shoot() {
        engine.bullets.add(new Bullet());
        Integer number = engine.bullets.size();
        engine.bullets.get(number-1).positionX = engine.player.positionX;
        engine.bullets.get(number-1).positionY = engine.player.positionY;
        engine.bullets.get(number-1).angle = engine.player.angle;
    }

}
