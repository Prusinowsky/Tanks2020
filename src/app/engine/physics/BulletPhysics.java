package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;

/**
 * Obiekt odpowiedzialny za fizykę kul
 */
public class BulletPhysics {

    private Engine engine;

    public BulletPhysics(Engine engine){
        this.engine = engine;
    }

    public void handle(){
        for(Integer i=0; i < engine.bullets.size(); i++){
            handleSingleBullet(engine.bullets.get(i));
        }
    }

    public void handleSingleBullet(Bullet bullet){
        moveSingle(bullet);
        destroyObstacle(bullet);
        destroyEnemyTank(bullet);
    }

    public void moveSingle(Bullet bullet){
        if(bullet.angle == 0){
            bullet.positionY -= 4;
        }
        else if(bullet.angle == 90){
            bullet.positionX += 4;
        }
        else if(bullet.angle == 180){
            bullet.positionY += 4;
        }
        else if(bullet.angle == 270){
            bullet.positionX -= 4;
        }
    }

    public void destroyObstacle(Bullet bullet){
        if(!engine.isOnMap(bullet)){
            engine.bullets.remove(bullet);
            return;
        }
        if(engine.isOpaqueObject(engine.map.layers[1], bullet.getCoordinateX(), bullet.getCoordinateY())){
            engine.bullets.remove(bullet);
        }
        if(engine.isDestructibleObject(engine.map.layers[1], bullet.getCoordinateX(), bullet.getCoordinateY())){
            engine.map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()] = null;
        }
    }

    public void destroyEnemyTank(Bullet bullet){
        for(Integer i=0; i < engine.enemies.size(); i++){
            if(!engine.isOnMap(bullet)){
                engine.bullets.remove(bullet);
                continue;
            }
            if(engine.enemies.get(i).isOnTheSameCoordinate(bullet)){
                engine.enemies.remove(engine.enemies.get(i));
                engine.bullets.remove(bullet);
            }
        }
    }
}
