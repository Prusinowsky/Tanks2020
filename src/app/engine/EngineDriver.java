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

    public void moveUp(){
        if(engine.player.getCoordinateY()-1>=0 && engine.player.getCoordinateY()-1 < engine.map.height && !engine.player.inAnimation)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY()-1] == null){
                new MoveTankAnimation(engine.player, 0, -32);
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY() - 1].isOpaque()) {
                new MoveTankAnimation(engine.player, 0, -32);
            }
            else engine.player.angle = 0;
    }

    public void moveDown(){
        if(engine.player.getCoordinateY()+1>=0 && engine.player.getCoordinateY()+1 < engine.map.height && !engine.player.inAnimation)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY()+1] == null){
                new MoveTankAnimation(engine.player, 0, 32);
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX()][engine.player.getCoordinateY() + 1].isOpaque()) {
                new MoveTankAnimation(engine.player, 0, 32);
            }
            else engine.player.angle = 180;
    }

    public void moveRight(){
        if(engine.player.getCoordinateX()+1>=0 && engine.player.getCoordinateX()+1 < engine.map.width && !engine.player.inAnimation)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()+1][engine.player.getCoordinateY()] == null){
                new MoveTankAnimation(engine.player, 32, 0);
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX() + 1][engine.player.getCoordinateY()].isOpaque()) {
                new MoveTankAnimation(engine.player, 32, 0);
            }
            else engine.player.angle = 90;
    }

    public void moveLeft(){
        if(engine.player.getCoordinateX()-1>=0 && engine.player.getCoordinateX()-1 < engine.map.width && !engine.player.inAnimation)
            if(engine.map.layers[1].blocks[engine.player.getCoordinateX()-1][engine.player.getCoordinateY()] == null){
                new MoveTankAnimation(engine.player, -32, 0);
            }
            else if(!engine.map.layers[1].blocks[engine.player.getCoordinateX() - 1][engine.player.getCoordinateY()].isOpaque()) {
                new MoveTankAnimation(engine.player, -32, 0);
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
