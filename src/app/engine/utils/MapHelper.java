package app.engine.utils;


import app.entities.map.MapEntity;
import app.entities.map.MapLayer;
import app.entities.map.MapObject;

/**
 * Klasa zawierajaca metody pomocnicze
 */
public class MapHelper {

    public static Boolean isOnMap(MapEntity map, MapObject object){
        return object != null
                && isOnMap(map, object.getCoordinateX(), object.getCoordinateY());
    }

    public static Boolean isOnMap(MapEntity map, Integer coordinateX, Integer coordinateY){
        return coordinateX >= 0 && coordinateX < map.width
                && coordinateY >= 0 && coordinateY < map.height;
    }

    public static Boolean isOnLayer(MapLayer layer, MapObject object){
        return object != null
                && isOnLayer(layer, object.getCoordinateX(), object.getCoordinateY());
    }

    public static Boolean isOnLayer(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return coordinateX >= 0 && coordinateX < layer.width
                && coordinateY >= 0 && coordinateY < layer.height;
    }

    public static Boolean isEmptySpace(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return isOnLayer(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY] == null;
    }

    public static Boolean isPortalObject(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return !isEmptySpace(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY].isPortal();
    }

    public static Boolean isOpaqueObject(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return !isEmptySpace(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY].isOpaque();
    }

    public static Boolean isDestructibleObject(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return !isEmptySpace(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY].isDestructible();
    }
}
