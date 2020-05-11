package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Portal;

public class PortalPhysics {

    private Engine engine;
    private Portal portal;

    public PortalPhysics(Engine engine){
        this.engine = engine;
        init();
    }

    private void init(){
        if(engine.map == null) return;
        for(Integer layer = 0; layer < engine.map.numberOfLayers; layer++){
            for(Integer i = 0; i < engine.map.layers[layer].width; i++)
                for(Integer j = 0; j < engine.map.layers[layer].height; j++)
                    if(engine.map.layers[layer].blocks[j][i] instanceof Portal)
                    {
                        this.portal = (Portal) engine.map.layers[layer].blocks[j][i];
                        break;
                    }
        }
    }

    public void reinit(){
        init();
    }

    public void handle(){
        if(engine.getPlayer().isOnTheSameCoordinate(portal)){
            engine.nextLevel();
            engine.score += engine.lifes*100;
        }
    }

    public Portal getPortal(){
        return portal;
    }

}
