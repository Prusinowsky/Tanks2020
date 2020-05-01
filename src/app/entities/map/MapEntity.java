package app.entities.map;

import java.util.Arrays;
import java.util.Map;

/**
 * Obiekt rezprezentujący encję mapy
 */
public class MapEntity {

    /**
     * Kod mapy
     */
    public Integer code;

    /**
     * Nazwa mapy
     */
    public String name;

    /**
     * Wymairy planszy
     */
    public Integer width;
    public Integer height;

    /**
     * Liczba warstw
     */
    public Integer numberOfLayers;

    /**
     * Warstwy
     */
    public MapLayer layers[] = null;

    /**
     * Konstrukor domyślny
     */
    public MapEntity(){}

    /**
     * Konstrukotr inicjalizujący z parametrami
     * @param name nazwa mapy
     * @param layers warstwy mapy
     */
    public MapEntity(String name, MapLayer[] layers){
        this.name = name;
        this.numberOfLayers = layers.length;
        this.layers = layers;
    }

}
