package app.map;

import app.entities.MapEntity;
import app.map.interfaces.MapInterface;

public class Map implements MapInterface {

    private Integer gridX, gridY;
    private MapEntity[][] entities;

    /**
     * Laduje wszystkie elementy mapy
     */
    public void load(){
        // TODO: 07.04.2020
    }

    /**
     * Zwraca wszystkie encje mapy
     * @return
     */
    public MapEntity[][] getAllMapEntities(){
        return entities;
    };

    /**
     * Zwraca encję mapy o podanych koordynatach
     * @param x
     * @param y
     * @return
     */
    public MapEntity getMapEntity(Integer x, Integer y){
        return null;
    };
}
