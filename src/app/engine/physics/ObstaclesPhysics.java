package app.engine.physics;

import app.engine.Engine;
import app.entities.map.MapEntity;
import app.entities.map.MapLayer;
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
        for(Integer i = 0; i < obstacles.size(); i++){
            obstacles.get(i).handle();
        }
    }

    public void remove(ObstaclePhysics obstaclePhysics){
        obstacles.remove(obstaclePhysics);
    }

    public MapEntity getMap(){
        MapEntity map = new MapEntity();
        map.numberOfLayers = 2;
        map.code = engine.map.code;
        map.width = engine.map.width;
        map.height = engine.map.height;
        map.layers = new MapLayer[2];
        map.layers[0] = engine.map.layers[0];
        map.layers[1] = new MapLayer();
        map.layers[1].name = engine.map.layers[1].name;
        map.layers[1].width = engine.map.layers[1].width;
        map.layers[1].height = engine.map.layers[1].height;
        map.layers[1].blocks = new MapObject[map.layers[1].width][map.layers[1].height];
        for(Integer i = 0; i < obstacles.size(); i++)
            map.layers[1].blocks[obstacles.get(i).getObstacle().getCoordinateX()][obstacles.get(i).getObstacle().getCoordinateY()] = obstacles.get(i).getObstacle();
        return map;
    }
}
