package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.entities.map.objects.Bullet;

/**
 * Obiekt odpowiedzlany za fizykę gracza
 */
public class PlayerTankPhysics {

    private Engine engine;

    /**
     * Konstruktor domyslny
     * @param engine
     */
    public PlayerTankPhysics(Engine engine){
        this.engine = engine;
    }

    /**
     * Porusz gracza w góre
     */
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

    /**
     * Porusz gracza w dół
     */
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

    /**
     * Porusz gracza w prawo
     */
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


    /**
     * Porusz gracza w lewo
     */
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

    /**
     * Strzel
     */
    public void shoot() {
        engine.bullets.add(new Bullet());
        Integer number = engine.bullets.size();
        engine.bullets.get(number-1).positionX = engine.player.positionX;
        engine.bullets.get(number-1).positionY = engine.player.positionY;
        engine.bullets.get(number-1).angle = engine.player.angle;
    }
}
