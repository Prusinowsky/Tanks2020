package app.loaders.map;

import app.config.Config;
import app.config.interfaces.ConfigInterface;
import app.entities.MapEntity;
import app.entities.TextureEntity;
import app.loaders.texture.TextureLoader;
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
    private TextureLoaderInterface textureLoader;

    /**
     * Zawiera wszystkie mapy gry
     */
    public HashMap<String, MapEntity> maps;

    /**
     * Konstruktor domyslny
     */
    public MapLoader(){
        TextureLoaderInterface textureLoader = new TextureLoader();
        textureLoader.load();
        this.textureLoader = textureLoader;
        ConfigInterface config = Config.getInstance();
        config.load();
        this.config = config;
    };

    /**
     * Konstruktor domsylny
     */
    public MapLoader(TextureLoaderInterface textureLoader){
        this.config = textureLoader.getConfig();
        this.textureLoader = textureLoader;
    }

    /**
     * Konstruktor domsylny
     */
    public MapLoader(ConfigInterface config, TextureLoaderInterface textureLoader){
        this.config = config;
        this.textureLoader = textureLoader;
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
            HashMap <Integer, TextureEntity> mapPattern = loadMapPattern(i);
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
    public MapEntity convertToMapEntity(String name, String path, HashMap<Integer, TextureEntity> mapPattern){
        try {
            MapEntity map = new MapEntity();
            map.name = name;
            map.sizeX = Integer.parseInt(config.getProperty("map_width"));
            map.sizeY = Integer.parseInt(config.getProperty("map_height"));

            TextureEntity[][] textures = new TextureEntity[map.sizeX][map.sizeY];

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            for (Integer i = 0; i < map.sizeX; i++) {
                String line = scanner.nextLine();
                for (Integer j = 0; j < map.sizeY; j++) {
                    Integer code = Integer.parseInt(String.valueOf(line.charAt(j)));
                    textures[j][i] = mapPattern.get(code);
                }
            }
            map.blocks = textures;

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
    public HashMap<Integer, TextureEntity> loadMapPattern(Integer i){
        HashMap <Integer, TextureEntity> pattern =  new HashMap<Integer, TextureEntity>();
        pattern.put(0, textureLoader.getTexture(config.getProperty("map_ground_" + i)));
        pattern.put(1, textureLoader.getTexture(config.getProperty("map_destructible_" + i)));
        pattern.put(2, textureLoader.getTexture(config.getProperty("map_destroyed_" + i)));
        pattern.put(3, textureLoader.getTexture(config.getProperty("map_indestructible_" + i)));
        pattern.put(4, textureLoader.getTexture("Portal"));
        return pattern;
    }

    public MapEntity getMap(String name){
        return maps.get(name);
    }

}
