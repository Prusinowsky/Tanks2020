package app.engine.physics;

import app.engine.Engine;
import app.engine.utils.MapHelper;
import app.entities.map.objects.Bullet;

/**
 * Obiekt odpowiedzialny za fizykę kul
 */
public class BulletPhysics {

    private Engine engine;
    private Bullet bullet;

    public BulletPhysics(Engine engine, Bullet bullet){
        this.engine = engine;
        this.bullet = bullet;
    }

    /**
     * Metoda odpowiedzialna za obsługę pocisku
     */
    public void handle(){
        if(!MapHelper.isOnMap(engine.map, bullet)){
            engine.getPhysics().getBulletsPhysics().destroy(this);
            return;
        }
        bullet.positionX += 4*getXDirection();
        bullet.positionY += 4*getYDirection();
    }

    private Integer getXDirection(){
        if(bullet.angle == 90)
            return 1;
        if(bullet.angle == 270)
            return -1;
        return 0;
    }

    private Integer getYDirection(){
        if(bullet.angle == 180)
            return 1;
        if(bullet.angle == 0)
            return -1;
        return 0;
    }

}
