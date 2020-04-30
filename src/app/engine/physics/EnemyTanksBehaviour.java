package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.Enemy;

import java.util.Random;

public class EnemyTanksBehaviour {

    private Engine engine;
    private Random generator = new Random();

    public EnemyTanksBehaviour(Engine engine){
        this.engine = engine;
    }

    public void handleTanks(){
        for(Integer i=0; i < engine.enemies.size(); i++){
            handleSingleTank(engine.enemies.get(i));
        }
    }

    public void handleSingleTank(Enemy enemy){
        moveSingleTank(enemy);
        //shootTank(enemy);
    }

    public void moveSingleTank(Enemy enemy){
        if(enemy.inAnimation) return;
        if(enemy.getCoordinateX()+1 == engine.player.getCoordinateX() && enemy.getCoordinateY() == engine.player.getCoordinateY()){
            moveLeftSingleTank(enemy);
        }
        else if(enemy.getCoordinateX()-1 == engine.player.getCoordinateX() && enemy.getCoordinateY() == engine.player.getCoordinateY()){
            moveRightSingleTank(enemy);
        }
        else if(enemy.getCoordinateX() == engine.player.getCoordinateX() && enemy.getCoordinateY()-1 == engine.player.getCoordinateY()){
            moveDownSingleTank(enemy);
        }
        else if(enemy.getCoordinateX() == engine.player.getCoordinateX() && enemy.getCoordinateY()+1 == engine.player.getCoordinateY()){
            moveUpSingleTank(enemy);
        }
        else {
            if (enemy.angle == 0) moveUpSingleTank(enemy);
            if (enemy.angle == 90) moveRightSingleTank(enemy);
            if (enemy.angle == 180) moveDownSingleTank(enemy);
            if (enemy.angle == 270) moveLeftSingleTank(enemy);
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

    public void moveRightSingleTank(Enemy enemy){
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

    public void moveDownSingleTank(Enemy enemy){
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

    public void moveLeftSingleTank(Enemy enemy){
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

    /*public void shootTank(Enemy enemy){
        if(enemy.getCoordinateX() == engine.player.getCoordinateX() || enemy.getCoordinateY() == engine.player.getCoordinateY()){
            singleShootEnemyTank(enemy);
        }
        /*Integer enemyX = enemy.getCoordinateX();
        Integer enemyY = enemy.getCoordinateY();
        Integer playerX = engine.player.getCoordinateX();
        Integer playerY = engine.player.getCoordinateY();

        if(enemyX == playerX){
            if(enemyY < playerY){
                compareBeforeShootY(enemy,enemyY,playerY,enemyX);
            }
            else{
                compareBeforeShootY(enemy,playerY,enemyY,enemyX);
            }
        }
        else if(enemyY == playerY){
            if(enemyX < playerX){
                compareBeforeShootY(enemy,enemyX,playerX,enemyY);
            }
            else{
                compareBeforeShootY(enemy,playerX,enemyX,enemyY);
            }
        }
    }

    public void compareBeforeShootY(Enemy enemy, Integer a, Integer b, Integer c){
        for(Integer i=a; i<b; i+=32){
            if(engine.map.layers[1].blocks[c][i].isOpaque()) {
                return;
            }
        }
        singleShootEnemyTank(enemy);
    }

    public void compareBeforeShootX(Enemy enemy, Integer a, Integer b, Integer c){
        for(Integer i=a; i<b; i+=32){
            if(engine.map.layers[1].blocks[i][c].isOpaque()) {
                return;
            }
        }
        singleShootEnemyTank(enemy);
    }*/

    public void singleShootTank(Enemy enemy){
        engine.bullets.add(new Bullet());
        Integer number = engine.bullets.size();
        engine.bullets.get(number-1).angle = enemy.angle;
        if(engine.bullets.get(number-1).angle == 0){
            engine.bullets.get(number-1).positionX = enemy.positionX;
            engine.bullets.get(number-1).positionY = enemy.positionY - 32;
        }
        else if(engine.bullets.get(number-1).angle == 90){
            engine.bullets.get(number-1).positionX = enemy.positionX + 32;
            engine.bullets.get(number-1).positionY = enemy.positionY;
        }
        else if(engine.bullets.get(number-1).angle == 180){
            engine.bullets.get(number-1).positionX = enemy.positionX;
            engine.bullets.get(number-1).positionY = enemy.positionY + 32;
        }
        else if(engine.bullets.get(number-1).angle == 270){
            engine.bullets.get(number-1).positionX = enemy.positionX - 32;
            engine.bullets.get(number-1).positionY = enemy.positionY;
        }
    }
}
