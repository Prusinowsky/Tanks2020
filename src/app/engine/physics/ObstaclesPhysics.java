package app.engine.physics;

import app.engine.Engine;
import app.entities.map.MapObject;

import java.util.ArrayList;

public class ObstaclesPhysics {

    private Engine engine;
    private ArrayList<ObstaclePhysics> obstacles;

    public ObstaclesPhysics(Engine engine){
        this.engine = engine;
        init();
    }

    private void init(){
        obstacles = new ArrayList<ObstaclePhysics>();
        if(engine.map == null) return;
        for(Integer layer = 0; layer < engine.map.numberOfLayers; layer++){
            for(Integer i = 0; i < engine.map.layers[layer].width; i++)
                for(Integer j = 0; j < engine.map.layers[layer].height; j++)
                    if(engine.map.layers[layer].blocks[j][i] != null && engine.map.layers[layer].blocks[j][i].isOpaque())
                        obstacles.add(new ObstaclePhysics(engine, engine.map.layers[layer].blocks[j][i]));
        }
    }

    public void reinit(){
        init();
    }

    public void handle() {

    }
}
