package app.entities.map;

/**
 * Obiekt rezprezentujący encję mapy
 */
public class MapEntity implements Cloneable {

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
    public MapLayer layers[];

    /**
     * Konstrukor domyślny
     */
    public MapEntity(){}

    /**
     * Konstrukotr inicjalizujący z parametrami
     * @param name
     */
    public MapEntity(String name, MapLayer[] layers){
        this.name = name;
        this.numberOfLayers = layers.length;
        this.layers = layers;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
