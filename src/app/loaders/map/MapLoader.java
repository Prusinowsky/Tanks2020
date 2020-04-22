package app.loaders.map;

import app.Container;
import app.config.ConfigInterface;
import app.entities.MapEntity;
import app.entities.map.MapBlockEntity;
import app.entities.map.MapGroundEntity;
import app.entities.map.MapObjectInterface;
import app.entities.map.MapPortalEntity;
import app.loaders.texture.TextureLoaderInterface;

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
     * Konstruktor domsylny
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
            HashMap <Integer, MapObjectInterface> mapPattern = loadMapPattern(i);
            MapEntity map = convertToMapEntity(name, path, mapPattern);
            maps.put(name, map);
        }
    };

    /**
     * Zwraca encję mapy
     * @param name
     * @param path
     * @param mapPattern
     * @return
     */
    public MapEntity convertToMapEntity(String name, String path, HashMap<Integer, MapObjectInterface> mapPattern){
        try {
            MapEntity map = new MapEntity();
            map.name = name;
            map.sizeX = Integer.parseInt(config.getProperty("map_width"));
            map.sizeY = Integer.parseInt(config.getProperty("map_height"));

            MapObjectInterface[][] objectEntities = new MapObjectInterface[map.sizeX][map.sizeY];

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            for (Integer i = 0; i < map.sizeX; i++) {
                String line = scanner.nextLine();
                for (Integer j = 0; j < map.sizeY; j++) {
                    Integer code = Integer.parseInt(String.valueOf(line.charAt(j)));
                    objectEntities[j][i] = mapPattern.get(code);
                }
            }
            map.blocks = objectEntities;

            return map;
        } catch (Exception e){
            System.out.println("Error during converting map + " + e.getMessage());
            return null;
        }
    }

    /**
     * Laduje wzor przeksztalcen cyfr na tekstury.
     * @param i
     * @return
     */
    public HashMap<Integer, MapObjectInterface> loadMapPattern(Integer i){
        HashMap <Integer, MapObjectInterface> pattern =  new HashMap<Integer, MapObjectInterface>();
        pattern.put(0, new MapGroundEntity());
        pattern.put(1, new MapBlockEntity(MapBlockEntity.BlockType.DESTRUCTIBLE));
        pattern.put(2, new MapBlockEntity(MapBlockEntity.BlockType.DESTROYED));
        pattern.put(3, new MapBlockEntity(MapBlockEntity.BlockType.UNDESTRUCTIBLE));
        pattern.put(4, new MapPortalEntity());
        return pattern;
    }

    public MapEntity getMap(String name){
        return maps.get(name);
    }

}
