package app.engine.physics;

import app.engine.Engine;
import app.entities.map.MapObject;

public class ObstaclePhysics {

    private Engine engine;
    private MapObject object;

    public ObstaclePhysics(Engine engine, MapObject object){
        this.engine = engine;
        this.object = object;
    }

    public void handle(){
        BulletPhysics[] bulletsPhysics = engine.getPhysics().getBulletsPhysics().getBulletPhysics();
        for(Integer i = 0; i < bulletsPhysics.length; i++)
            if(bulletsPhysics[i].getBullet().isOnTheSameCoordinate(object)){
                engine.getPhysics().getBulletsPhysics().remove(bulletsPhysics[i]);
                if(object.isDestructible()){
                    engine.getPhysics().getObstaclesPhysics().remove(this);
                    engine.score -= 10;
                }
                return;
            }
    }

    public MapObject getObstacle(){
        return object;
    }
}
