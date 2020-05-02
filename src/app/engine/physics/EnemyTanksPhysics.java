package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.entities.map.objects.Bullet;
import app.entities.map.objects.EnemyBullet;
import app.entities.map.tanks.Enemy;

import java.util.Random;

/**
 * Obiekt odpowiedzialny za fizykę wrogów
 */
public class EnemyTanksPhysics {

    private Engine engine;
    private Random generator = new Random();

    public EnemyTanksPhysics(Engine engine){
        this.engine = engine;
    }

    public void handle(){
        for(Integer i=0; i < engine.enemies.size(); i++){
            moveSingleTank(engine.enemies.get(i));
            shoot(engine.enemies.get(i));
        }
    }

    public void moveSingleTank(Enemy enemy){
        if(enemy.inAnimation) return;
        if(enemy.getCoordinateX()+1 == engine.player.getCoordinateX() && enemy.getCoordinateY() == engine.player.getCoordinateY()){
            moveLeftSingle(enemy);
        }
        else if(enemy.getCoordinateX()-1 == engine.player.getCoordinateX() && enemy.getCoordinateY() == engine.player.getCoordinateY()){
            moveRightSingle(enemy);
        }
        else if(enemy.getCoordinateX() == engine.player.getCoordinateX() && enemy.getCoordinateY()-1 == engine.player.getCoordinateY()){
            moveDownSingle(enemy);
        }
        else if(enemy.getCoordinateX() == engine.player.getCoordinateX() && enemy.getCoordinateY()+1 == engine.player.getCoordinateY()){
            moveUpSingleTank(enemy);
        }
        else {
            if (enemy.angle == 0) moveUpSingleTank(enemy);
            if (enemy.angle == 90) moveRightSingle(enemy);
            if (enemy.angle == 180) moveDownSingle(enemy);
            if (enemy.angle == 270) moveLeftSingle(enemy);
        }
    }

    public void moveUpSingleTank(Enemy enemy){
        if(enemy.getCoordinateY()-1>=0 && enemy.getCoordinateY()-1 < engine.map.height) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1] == null) {
                new MoveTankAnimation(enemy, 0, -32);
            }else if (!engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1].isOpaque()) {
                new MoveTankAnimation(enemy, 0, -32);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveRightSingle(Enemy enemy){
        if(enemy.getCoordinateX()+1>=0 && enemy.getCoordinateX()+1 < engine.map.width) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()] == null) {
                new MoveTankAnimation(enemy, 32, 0);
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()].isOpaque()) {
                new MoveTankAnimation(enemy, 32, 0);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveDownSingle(Enemy enemy){
        if(enemy.getCoordinateY()+1>=0 && enemy.getCoordinateY()+1 < engine.map.height) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1] == null) {
                new MoveTankAnimation(enemy, 0, 32);
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1].isOpaque()) {
                new MoveTankAnimation(enemy, 0, 32);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveLeftSingle(Enemy enemy){
        if(enemy.getCoordinateX()-1>=0 && enemy.getCoordinateX()-1 < engine.map.width) {
            if (engine.map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()] == null) {
                new MoveTankAnimation(enemy, -32, 0);
            } else if (!engine.map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()].isOpaque()) {
                new MoveTankAnimation(enemy, -32, 0);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void randomDirection(Enemy enemy){
        Integer number = generator.nextInt(4);
        if(number == 0){
            enemy.angle = 0;
        }
        else if(number == 1){
            enemy.angle = 90;
        }
        else if(number == 2){
            enemy.angle = 180;
        }
        else if(number == 3){
            enemy.angle = 270;
        }
    }

    public void shoot(Enemy enemy){
        trackPlayer(enemy);
    }

    public void trackPlayer(Enemy enemy){
        if(enemy.getCoordinateX() == engine.player.getCoordinateX()){
            if(enemy.getCoordinateY() > engine.player.getCoordinateY()){
                if(checkObstaclesBetweenTanksX(engine.player.getCoordinateY(), enemy.getCoordinateY(), enemy.getCoordinateX())){
                    enemy.angle = 0;
                    singleShoot(enemy);
                }
            }
            else {
                if(checkObstaclesBetweenTanksX(enemy.getCoordinateY(), engine.player.getCoordinateY(), enemy.getCoordinateX())){
                    enemy.angle = 180;
                    singleShoot(enemy);
                }
            }
        }
        if(enemy.getCoordinateY() == engine.player.getCoordinateY()){
            if(enemy.getCoordinateX() > engine.player.getCoordinateX()){
                if(checkObstaclesBetweenTanksY(engine.player.getCoordinateX(), enemy.getCoordinateX(), enemy.getCoordinateY())){
                    enemy.angle = 270;
                    singleShoot(enemy);
                }
            }
            else {
                if(checkObstaclesBetweenTanksY(enemy.getCoordinateX(), engine.player.getCoordinateX(), enemy.getCoordinateY())){
                    enemy.angle = 90;
                    singleShoot(enemy);
                }
            }
        }
    }

    public Boolean checkObstaclesBetweenTanksY(Integer from, Integer to, Integer constantY){
        Integer checker=0;
        for(Integer i=from; i<to; i+=1){
            if(!engine.isEmptySpace(engine.map.layers[1],i,constantY)) checker+=1;
        }
        if(checker != 0) return false;
        else return true;
    }

    public Boolean checkObstaclesBetweenTanksX(Integer from, Integer to, Integer constantX){
        Integer checker=0;
        for(Integer i=from; i<to; i+=1){
            if(!engine.isEmptySpace(engine.map.layers[1],constantX,i)) checker+=1;
        }
        if(checker != 0) return false;
        else return true;
    }

    public void singleShoot(Enemy enemy){
        engine.enemyBullets.add(new EnemyBullet());
        Integer number = engine.enemyBullets.size();
        engine.enemyBullets.get(number-1).angle = enemy.angle;
        engine.enemyBullets.get(number-1).positionX = enemy.positionX;
        engine.enemyBullets.get(number-1).positionY = enemy.positionY;
        //System.out.println("strzał "+number+" ("+enemy.positionX+","+enemy.positionY+")");
    }
}
