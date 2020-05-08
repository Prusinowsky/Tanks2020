package app.engine.physics;

import app.engine.Engine;
import app.entities.map.MapObject;
import app.entities.map.objects.Bullet;

public class ObstaclePhysics {

    private Engine engine;
    private MapObject object;

    public ObstaclePhysics(Engine engine, MapObject object){
        this.engine = engine;
        this.object = object;
    }

    public void handle(){
        destroy();
    }

    public void destroy(){
        for(Bullet bullet : engine.bullets){
            if(bullet.isOnTheSameCoordinate(object)){
                if(object.isDestructible()) {

                }
                break;
            }
        }
    }

    public Boolean canBeDelete(){
        return object == null;
    }
}
