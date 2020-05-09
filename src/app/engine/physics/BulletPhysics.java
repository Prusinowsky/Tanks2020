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
            engine.getPhysics().getBulletsPhysics().remove(this);
            return;
        }
        bullet.positionX += 4 * bullet.getDirectionX();
        bullet.positionY += 4 * bullet.getDirectionY();
    }

    public Bullet getBullet(){
        return bullet;
    }

}
