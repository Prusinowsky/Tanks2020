package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.engine.utils.MapHelper;
import app.engine.utils.Stoper;
import app.entities.map.MapEntity;
import app.entities.map.tanks.Player;

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

    public void handle(){
        destroy();
    }

    public void moveUp(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnUp();
        MapEntity map = engine.getMap();
        if(MapHelper.isOnMap(map, engine.player.getCoordinateX(), engine.player.getCoordinateY() - 1)
                && !MapHelper.isOpaqueObject(map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY() - 1)
        )
            new MoveTankAnimation(engine.player, 0, -32);
        movementStoper.reset();
    }

    public void moveRight(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnRight();
        MapEntity map = engine.getMap();
        if(MapHelper.isOnMap(map, engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())
                && !MapHelper.isOpaqueObject(map.layers[1], engine.player.getCoordinateX() + 1, engine.player.getCoordinateY())
        )
            new MoveTankAnimation(engine.player, 32, 0);
        movementStoper.reset();
    }

    public void moveDown(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnDown();
        MapEntity map = engine.getMap();
        if(MapHelper.isOnMap(map, engine.player.getCoordinateX(), engine.player.getCoordinateY() + 1)
                && !MapHelper.isOpaqueObject(map.layers[1], engine.player.getCoordinateX(), engine.player.getCoordinateY() + 1)
        )
            new MoveTankAnimation(engine.player, 0, 32);
        movementStoper.reset();
    }

    public void moveLeft(){
        if(movementStoper.getElapsedTime() < 16*12) return;
        engine.player.turnLeft();
        MapEntity map = engine.getMap();
        if(MapHelper.isOnMap(map, engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())
                && !MapHelper.isOpaqueObject(map.layers[1], engine.player.getCoordinateX() - 1, engine.player.getCoordinateY())
        )
            new MoveTankAnimation(engine.player, -32, 0);
        movementStoper.reset();
    }

    private void destroy(){
        BulletPhysics[] bulletsPhysics = engine.getPhysics().getBulletsPhysics().getBulletPhysics();
        for(Integer i = 0; i < bulletsPhysics.length; i++)
            if(bulletsPhysics[i].getBullet().isOnTheSameCoordinate(engine.getPlayer()) && bulletsPhysics[i].getBullet().team != engine.getPlayer().getClass()){
                engine.getPhysics().getBulletsPhysics().remove(bulletsPhysics[i]);
                engine.reloadByDeath();
                return;
            }
    }

    public void shoot(){
        if(shootStoper.getElapsedTime() < 200) return;
            engine.getPhysics().getBulletsPhysics().shoot(engine.player);
        shootStoper.reset();
    }

    public Player getPlayer(){
        return engine.player;
    }
}
