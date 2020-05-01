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
        if(!(bullet.getCoordinateY()>=0 && bullet.getCoordinateY() < engine.map.height && bullet.getCoordinateX()>=0 && bullet.getCoordinateX() < engine.map.width)){
            engine.bullets.remove(bullet);
        }
        else if(engine.map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()] != null &&
                engine.map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()].isOpaque()){
            if(engine.map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()].isDestructible()) {
                engine.map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()] = null;
                engine.bullets.remove(bullet);
            }
            else {
                engine.bullets.remove(bullet);
            }
        }
    }

    public void destroyEnemyTank(Bullet bullet){
        for(Integer i=0; i < engine.enemies.size(); i++){
            if(!(bullet.getCoordinateY()>=0 && bullet.getCoordinateY() < engine.map.height && bullet.getCoordinateX()>=0 && bullet.getCoordinateX() < engine.map.width)){
                engine.bullets.remove(bullet);
            }
            else if(engine.enemies.get(i).getCoordinateX() == bullet.getCoordinateX() && engine.enemies.get(i).getCoordinateY() == bullet.getCoordinateY()){
                engine.enemies.remove(engine.enemies.get(i));
                engine.bullets.remove(bullet);
            }
        }
    }
}
