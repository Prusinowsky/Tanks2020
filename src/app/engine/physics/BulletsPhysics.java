package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.AbstractTank;

import java.util.ArrayList;

public class BulletsPhysics {

    private Engine engine;
    private ArrayList<BulletPhysics> bullets;

    public BulletsPhysics(Engine engine){
        this.engine = engine;
        init();
    }

    public void init(){
        bullets = new ArrayList<BulletPhysics>();
    }

    /**
     * Metoda odpowiedzialna za obsługę wszystkich pocisków
     */
    public void handle() {
        for(Integer i = 0; i < bullets.size(); i++){
            BulletPhysics bullet = bullets.get(i);
            bullet.handle();
        }
    }

    public void shoot(AbstractTank tank){
        Bullet bullet = new Bullet();
        bullet.angle = tank.angle;
        bullet.team = tank.getClass();
        bullet.positionX = tank.positionX + tank.getDirectionX()*32;
        bullet.positionY = tank.positionY + tank.getDirectionY()*32;
        engine.bullets.add(bullet);
        bullets.add(new BulletPhysics(engine, bullet));
    }

    public void remove(BulletPhysics bulletPhysics){
        bullets.remove(bulletPhysics);
    }

    public Bullet[] getBullets(){
        return bullets.stream().map(BulletPhysics::getBullet).toArray(Bullet[]::new);
    }

    public BulletPhysics[] getBulletPhysics(){
        return bullets.stream().toArray(BulletPhysics[]::new);
    }

}
