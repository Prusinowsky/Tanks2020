package app.engine.physics;

import app.engine.Engine;
import app.engine.animations.MoveTankAnimation;
import app.engine.utils.Stoper;
import app.engine.utils.Tracker;
import app.entities.map.MapEntity;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.Enemy;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EnemyPhysics {

    private Engine engine;
    private Enemy enemy;
    private Tracker tracker;
    private Stoper movementStoper = new Stoper();
    private Stoper shootStoper = new Stoper();
    private Random generator = new Random();

    public EnemyPhysics(Engine engine, Enemy enemy){
        this.engine = engine;
        this.enemy = enemy;
        this.tracker = new Tracker(engine);
    }

    public void handle(){
        destroy();
        if(shootStoper.getElapsedTime() > 500 && !enemy.inAnimation){
            shoot();
            shootStoper.reset();
        }
        if(movementStoper.getElapsedTime() > 12*16 && !enemy.inAnimation){
            move();
            movementStoper.reset();
        }
    }

    private void move(){
        if (enemy.angle == 0) moveUp(enemy);
        if (enemy.angle == 90) moveRight(enemy);
        if (enemy.angle == 180) moveDown(enemy);
        if (enemy.angle == 270) moveLeft(enemy);
    }

    public void moveUp(Enemy enemy){
        MapEntity map = engine.getMap();
        if(enemy.getCoordinateY()-1>=0 && enemy.getCoordinateY()-1 < map.height) {
            if (map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1] == null) {
                new MoveTankAnimation(enemy, 0, -32);
            }else if (!map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1].isOpaque()) {
                new MoveTankAnimation(enemy, 0, -32);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveRight(Enemy enemy){
        MapEntity map = engine.getMap();
        if(enemy.getCoordinateX()+1>=0 && enemy.getCoordinateX()+1 < map.width) {
            if (map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()] == null) {
                new MoveTankAnimation(enemy, 32, 0);
            } else if (!map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()].isOpaque()) {
                new MoveTankAnimation(enemy, 32, 0);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveDown(Enemy enemy){
        MapEntity map = engine.getMap();
        if(enemy.getCoordinateY()+1>=0 && enemy.getCoordinateY()+1 < map.height) {
            if (map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1] == null) {
                new MoveTankAnimation(enemy, 0, 32);
            } else if (!map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1].isOpaque()) {
                new MoveTankAnimation(enemy, 0, 32);
            } else {
                randomDirection(enemy);
            }
        }
        else{
            randomDirection(enemy);
        }
    }

    public void moveLeft(Enemy enemy){
        MapEntity map = engine.getMap();
        if(enemy.getCoordinateX()-1>=0 && enemy.getCoordinateX()-1 < map.width) {
            if (map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()] == null) {
                new MoveTankAnimation(enemy, -32, 0);
            } else if (!map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()].isOpaque()) {
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

    private void shoot(){
        if(tracker.trackPlayer(enemy))
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if(enemy.alive)
                        engine.getPhysics().getBulletsPhysics().shoot(enemy);
                }
            }, 500);
    }

    private void destroy(){
        BulletPhysics[] bulletsPhysics = engine.getPhysics().getBulletsPhysics().getBulletPhysics();
        for(Integer i = 0; i < bulletsPhysics.length; i++)
            if(bulletsPhysics[i].getBullet().isOnTheSameCoordinate(enemy) && bulletsPhysics[i].getBullet().team != enemy.getClass()){
                enemy.alive = false;
                engine.getPhysics().getBulletsPhysics().remove(bulletsPhysics[i]);
                engine.getPhysics().getEnemiesPhysics().remove(this);
                return;
            }
    }

    public Enemy getEnemy(){
        return enemy;
    }
}
