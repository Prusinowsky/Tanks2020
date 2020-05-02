package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;
import app.entities.map.objects.EnemyBullet;

public class EnemyBulletPhysics {
    private Engine engine;

    public EnemyBulletPhysics(Engine engine){
        this.engine = engine;
    }

    public void handle(){
        for(Integer i=0; i < engine.enemyBullets.size(); i++){
            handleSingleBullet(engine.enemyBullets.get(i));
        }
    }

    public void handleSingleBullet(EnemyBullet enemyBullet){
        moveSingle(enemyBullet);
        destroyPlayerTank(enemyBullet);
        checkCollision(enemyBullet);
    }

    public void moveSingle(EnemyBullet enemyBullet){
        if(enemyBullet.angle == 0){
            enemyBullet.positionY -= 4;
        }
        else if(enemyBullet.angle == 90){
            enemyBullet.positionX += 4;
        }
        else if(enemyBullet.angle == 180){
            enemyBullet.positionY += 4;
        }
        else if(enemyBullet.angle == 270){
            enemyBullet.positionX -= 4;
        }
    }

    public void checkCollision(EnemyBullet enemyBullet){
        if(!engine.isOnMap(enemyBullet)){
            engine.enemyBullets.remove(enemyBullet);
            return;
        }
        if(engine.isOpaqueObject(engine.map.layers[1], enemyBullet.getCoordinateX(), enemyBullet.getCoordinateY())){
            engine.enemyBullets.remove(enemyBullet);
        }
    }

    public void destroyPlayerTank(EnemyBullet enemyBullet){
        if(!engine.isOnMap(enemyBullet)){
            engine.bullets.remove(enemyBullet);
        }
        if(engine.player.isOnTheSameCoordinate(enemyBullet)){
            engine.enemyBullets.remove(enemyBullet);
            engine.lifes -= 1;
        }
    }
}
