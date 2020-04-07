package app.loaders.map;

import app.config.Config;
import app.config.interfaces.ConfigInterface;
import app.entities.MapEntity;
import app.loaders.map.MapLoaderInterface;
import app.loaders.texture.TextureLoader;
import app.loaders.texture.TextureLoaderInterface;
import app.map.interfaces.MapInterface;

import java.util.HashMap;

/**
 * Obiekt odpowiedzielny za ładaowanie mapy i przekształcanie
 * go na obiekt Map
 */
public class MapLoader implements MapLoaderInterface {
    private TextureLoaderInterface textureLoader = null;
    public HashMap<String, MapEntity> maps;

    /**
     * Konstruktor domyslny
     */
    MapLoader(){
        TextureLoaderInterface textureLoader = new TextureLoader();
        textureLoader.loadAll();
        setTextureLoader(textureLoader);
    };

    /**
     * Konstruktor domsylny
     */
    MapLoader(TextureLoaderInterface textureLoader){
        setTextureLoader(textureLoader);
    }

    /**
     * Laduje mapę
     */
    public void load(){
        ConfigInterface config = Config.getInstance();
        load(config);
    };

    /**
     * Ustawia texture loader
     */
    public void setTextureLoader(TextureLoaderInterface textureLoader){
        this.textureLoader = textureLoader;
    }

    /**
     * Laduje mapę
     * @param config
     */
    public void load(ConfigInterface config){
        Integer number = Integer.parseInt(config.getProperty("map_numbers"));
        maps = new HashMap<String, MapEntity>();
        String pathToMap = config.getProperty("maps_path");
        for(Integer i = 0; i < number; i++){
            String name = config.getProperty("map_name_" + i);
            String path = pathToMap + config.getProperty("map_path_" + i);
            MapEntity map = convertToMapEntity(name, path);
            //maps.put();
        }
    };

    /**
     * Zwraca obiekt mapy
     * @param name
     * @return
     */
    public MapEntity convertToMapEntity(String name, String path){
        // TODO: 07.04.2020
        return null;
    }


}
