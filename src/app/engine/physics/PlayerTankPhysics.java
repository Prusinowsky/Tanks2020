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
        if(!engine.isOnMap(engine.player.getCoordinateX(), engine.player.getCoordinateY()-1)
                || engine.player.inAnimation)
            return;
        if(!engine.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY()-1)){
            new MoveTankAnimation(engine.player, 0, -32);
        }
        if(engine.isPortalObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY()-1)){
            engine.nextLevel();
        }
        engine.player.angle = 0;
    }

    /**
     * Porusz gracza w dół
     */
    public void moveDown(){
        if(!engine.isOnMap(engine.player.getCoordinateX(), engine.player.getCoordinateY()+1)
                || engine.player.inAnimation)
            return;
        if(!engine.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY()+1)){
            new MoveTankAnimation(engine.player, 0, 32);
        }
        if(engine.isPortalObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY()+1)){
            engine.nextLevel();
        }
        engine.player.angle = 180;
    }

    /**
     * Porusz gracza w prawo
     */
    public void moveRight(){
        if(!engine.isOnMap(engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())
                || engine.player.inAnimation)
            return;
        if(!engine.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())){
            new MoveTankAnimation(engine.player, 32, 0);
        }
        if(engine.isPortalObject(engine.map.layers[1], engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())){
            engine.nextLevel();
        }
        engine.player.angle = 90;
    }


    /**
     * Porusz gracza w lewo
     */
    public void moveLeft(){
        if(!engine.isOnMap(engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())
                || engine.player.inAnimation)
            return;
        if(!engine.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())){
            new MoveTankAnimation(engine.player, -32, 0);
        }
        if(engine.isPortalObject(engine.map.layers[1], engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())){
            engine.nextLevel();
        }
        engine.player.angle = 270;
    }

    /**
     * Strzel
     */
    public void shoot() {
        engine.bullets.add(new Bullet());
        engine.bullets.get(engine.bullets.size() - 1).positionX = engine.player.positionX;
        engine.bullets.get(engine.bullets.size() - 1).positionY = engine.player.positionY;
        engine.bullets.get(engine.bullets.size() - 1).angle = engine.player.angle;
    }
}
