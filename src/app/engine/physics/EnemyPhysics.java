package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.Enemy;

import java.util.Random;

public class EnemyPhysics {

    private Engine engine;
    private Enemy enemy;
    private Random generator = new Random();

    public EnemyPhysics(Engine engine, Enemy enemy){
        this.engine = engine;
        this.enemy = enemy;
    }

    public void handle(){
        destory();
    }

    public void destory(){
        Bullet toDelete = null;
        for(Bullet bullet : engine.bullets){
            if(bullet.isOnTheSameCoordinate(enemy)){
                toDelete = bullet;
                engine.enemies.remove(enemy);
                enemy = null;
            }
        }
        engine.bullets.remove(toDelete);
    }

    public Boolean canBeDelete(){
        return enemy == null;
    }
}
