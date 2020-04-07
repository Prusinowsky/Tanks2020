package app.loaders;

import app.config.interfaces.ConfigInterface;
import app.loaders.interfaces.MapLoaderInterface;
import app.map.interfaces.MapInterface;

/**
 * Obiekt odpowiedzielny za ładaowanie mapy i przekształcanie
 * go na obiekt Map
 */
public class MapLoader implements MapLoaderInterface {


    /**
     * Laduje mapę
     * @param config
     */
    public void load(ConfigInterface config){
        // TODO: 07.04.2020
    };

    /**
     * Zwraca obiekty map, może być wiele ze względu
     * na różne poziomy
     * @return
     */
    public MapInterface[] convertToMaps(){
        // TODO: 07.04.2020
        return null;
    };

    /**
     * Zwraca obiekt mapy
     * @param name
     * @return
     */
    public MapInterface convertToMap(String name){
        // TODO: 07.04.2020
        return null;
    }

}
