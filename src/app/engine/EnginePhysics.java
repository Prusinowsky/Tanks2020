package app.engine;

import app.entities.map.objects.Bullet;
import app.entities.map.tanks.Enemy;

/**
 * Obiekt odpowiedzialny za fizyke gry
 */
public class EnginePhysics {

    private Engine engine;

    public EnginePhysics(Engine engine){
        this.engine = engine;
    }

    public void handleBulletsBehaviour(){
        for(Integer i=0; i < engine.bullets.size(); i++){
            handleSingleBulletBehaviour(engine.bullets.get(i));
        }
    }

    public void handleSingleBulletBehaviour(Bullet bullet){
        moveSingleBullet(bullet);
        destroyObstacle(bullet);
        destroyEnemyTank(bullet);
    }

    public void moveSingleBullet(Bullet bullet){
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

    //NIEZROBIONE!!!
    public void destroyEnemyTank(Bullet bullet){
        if(!(bullet.getCoordinateY()>=0 && bullet.getCoordinateY() < engine.map.height && bullet.getCoordinateX()>=0 && bullet.getCoordinateX() < engine.map.width)){
            engine.bullets.remove(bullet);
        }
    }

    public void handleEnemyTanksBehaviour(){
        for(Integer i=0; i < engine.enemies.size(); i++){
            handleSingleEnemyTankBehaviour(engine.enemies.get(i));
        }
    }

    public void handleSingleEnemyTankBehaviour(Enemy enemy){
        moveSingleEnemyTank(enemy);
    }

    public void moveSingleEnemyTank(Enemy enemy){
        if(enemy.angle == 0) moveUpSingleEnemyTank(enemy);
        if(enemy.angle == 90) moveRightSingleEnemyTank(enemy);
        if(enemy.angle == 180) moveDownSingleEnemyTank(enemy);
        if(enemy.angle == 270) moveLeftSingleEnemyTank(enemy);
    }

    public void moveUpSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateY()-1>=0 && enemy.getCoordinateY()-1 < engine.map.height) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1] == null) {
                enemy.positionY -= 32;
                enemy.angle = 0;
            }else if (!engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1].isOpaque()) {
                enemy.positionY -= 32;
                enemy.angle = 0;
            } else {
                enemy.angle = 180;
            }
        }
    }

    public void moveRightSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateX()+1>=0 && enemy.getCoordinateX()+1 < engine.map.width) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()] == null) {
                enemy.positionX += 32;
                enemy.angle = 90;
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()].isOpaque()) {
                enemy.positionX += 32;
                enemy.angle = 90;
            } else {
                enemy.angle = 270;
            }
        }
    }

    public void moveDownSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateY()+1>=0 && enemy.getCoordinateY()+1 < engine.map.height) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1] == null) {
                enemy.positionY += 32;
                enemy.angle = 180;
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1].isOpaque()) {
                enemy.positionY += 32;
                enemy.angle = 180;
            } else {
                enemy.angle = 0;
            }
        }
    }

    public void moveLeftSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateX()-1>=0 && enemy.getCoordinateX()-1 < engine.map.width) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()] == null) {
                enemy.positionX -= 32;
                enemy.angle = 270;
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()].isOpaque()) {
                enemy.positionX -= 32;
                enemy.angle = 270;
            } else {
                enemy.angle = 90;
            }
        }
    }

}
