package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.engine.utils.MapHelper;
import app.engine.utils.Stoper;

/**
 * Obiekt odpowiedzlany za fizykę gracza
 */
public class PlayerPhysics {

    private Engine engine;
    private Stoper movementStoper = new Stoper();
    private Stoper shootStoper = new Stoper();

    /**
     * Konstruktor domyslny
     * @param engine
     */
    public PlayerPhysics(Engine engine){
        this.engine = engine;
    }

    public void moveUp(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnUp();
        if(MapHelper.isOnMap(engine.map, engine.player.getCoordinateX(), engine.player.getCoordinateY() - 1)
                && !MapHelper.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY() - 1)
        )
            new MoveTankAnimation(engine.player, 0, -32);
        movementStoper.reset();
    }

    public void moveRight(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnRight();
        if(MapHelper.isOnMap(engine.map, engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())
                && !MapHelper.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())
        )
            new MoveTankAnimation(engine.player, 32, 0);
        movementStoper.reset();
    }

    public void moveDown(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnDown();
        if(MapHelper.isOnMap(engine.map, engine.player.getCoordinateX(), engine.player.getCoordinateY() + 1)
                && !MapHelper.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY() + 1)
        )
            new MoveTankAnimation(engine.player, 0, 32);
        movementStoper.reset();
    }

    public void moveLeft(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnLeft();
        if(MapHelper.isOnMap(engine.map, engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())
                && !MapHelper.isOpaqueObject(engine.map.layers[1], engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())
        )
            new MoveTankAnimation(engine.player, -32, 0);
        movementStoper.reset();
    }

    public void shoot(){
        if(shootStoper.getElapsedTime() < 200) return;
            engine.getPhysics().getBulletsPhysics().shoot(engine.player);
        shootStoper.reset();
    }
}
