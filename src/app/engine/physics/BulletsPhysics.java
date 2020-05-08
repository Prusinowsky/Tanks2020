package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.AbstractTank;

import java.util.ArrayList;

public class BulletsPhysics {

    private Engine engine;
    private ArrayList<BulletPhysics> bullets, toDelete;

    public BulletsPhysics(Engine engine){
        this.engine = engine;
        init();
    }

    public void init(){
        bullets = new ArrayList<BulletPhysics>();
        toDelete = new ArrayList<BulletPhysics>();
    }

    public void shoot(AbstractTank tank){
        Bullet bullet = new Bullet();
        bullet.angle = tank.angle;
        bullet.positionX = tank.positionX;
        bullet.positionY = tank.positionY;
        engine.bullets.add(bullet);
        bullets.add(new BulletPhysics(engine, bullet));
    }

    /**
     * Metoda odpowiedzialna za obsługę wszystkich pocisków
     */
    public void handle() {
        for(BulletPhysics bullet : bullets)
            bullet.handle();
        bullets.removeAll(toDelete);
        toDelete.clear();
    }

    public void destroy(BulletPhysics bullet){
        toDelete.add(bullet);
    }
}
