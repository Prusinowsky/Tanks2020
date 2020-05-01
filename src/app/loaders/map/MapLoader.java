package app.loaders.map;

import app.Container;
import app.config.ConfigInterface;
import app.entities.map.MapEntity;
import app.entities.map.MapLayer;
import app.entities.map.MapObject;
import app.entities.map.objects.Portal;
import app.entities.map.obstacles.DestructibleObstacle;
import app.entities.map.obstacles.IndestructibleObstacle;
import app.entities.map.tiles.GroundTile;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Obiekt odpowiedzielny za ładaowanie mapy i przekształcanie
 * go na obiekt Map
 */
public class MapLoader implements MapLoaderInterface {
    private ConfigInterface config;

    /**
     * Zawiera wszystkie mapy gry
     */
    public HashMap<String, MapEntity> maps;

    /**
     * Konstruktor domyslny
     */
    public MapLoader(){
        this.config = Container.getInstance().provideConfig();
    };


    /**
     * Konstruktor domyslny
     * @param config Obiekt konfiguracyjny
     */
    public MapLoader(ConfigInterface config){
        this.config = config;
    }

    /**
     * Laduje mapę
     */
    public void load(){
        Integer number = Integer.parseInt(config.getProperty("map_numbers"));
        maps = new HashMap<String, MapEntity>();

        String pathToMap = config.getProperty("maps_path");
        for(Integer i = 0; i < number; i++){
            String name = config.getProperty("map_name_" + i);
            String path = pathToMap + config.getProperty("map_path_" + i);
            MapEntity map = convertToMapEntity(i, name, path);
            map.code = i;
            maps.put(name, map);
        }
    };

    /**
     * Zwraca encję mapy
     * @param mapCode kody mapu
     * @param mapName nazwa mapy
     * @param path ścieżka mapy
     * @return Encja mapy
     */
    public MapEntity convertToMapEntity(Integer mapCode, String mapName, String path){
        try {
            MapEntity map = new MapEntity();
            map.name = mapName;

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            map.numberOfLayers = Integer.parseInt(scanner.nextLine());
            map.width = Integer.parseInt(scanner.nextLine());
            map.height = Integer.parseInt(scanner.nextLine());

            MapLayer[] mapLayers = new MapLayer[2];

            for(Integer l = 0; l < 2; l++){
                scanner.nextLine();
                mapLayers[l] = new MapLayer();
                mapLayers[l].width = map.width;
                mapLayers[l].height = map.height;
                mapLayers[l].blocks = new MapObject[map.height][map.width];

                for (Integer i = 0; i < map.height; i++) {
                    String line = scanner.nextLine();
                    for (Integer j = 0; j < map.width; j++) {
                        Integer code = Integer.parseInt(String.valueOf(line.charAt(j)));
                        MapObject mapObject = toMapObject(code);
                        if(mapObject != null) {
                            mapObject.code = code;
                            mapObject.mapCode = mapCode;
                            mapObject.mapName = mapName;
                        }
                        mapLayers[l].blocks[j][i] = mapObject;
                    }
                }
            }

            map.layers = mapLayers;

            return map;
        } catch (Exception e){
            System.out.println("Error during converting map + " + e.getMessage());
            return null;
        }
    }

    @Override
    public MapEntity getMap(String name) {
        return maps.get(name);
    }

    private HashMap<Integer, MapObject> pattern(){
        HashMap<Integer, MapObject> pattern = new HashMap<Integer, MapObject>();

        pattern.put(0, null);
        pattern.put(1, new GroundTile());
        pattern.put(2, new DestructibleObstacle());
        pattern.put(4, new IndestructibleObstacle());
        pattern.put(5, new Portal());

        return pattern;
    }

    private MapObject toMapObject(Integer code){
        return pattern().get(code);
    }

}
