package app.entities;

/**
 * Obiekt rezprezentujący encję mapy
 */
public class MapEntity implements Cloneable {
    /**
     * Nazwa mapy
     */
    public String name;

    /**
     * Bloki mapy
     */
    public TextureEntity[][] blocks;

    /**
     * Wymairy planszy
     */
    public Integer sizeX;
    public Integer sizeY;

    /**
     * Konstrukor domyślny
     */
    public MapEntity(){}

    /**
     * Konstrukotr inicjalizujący z parametrami
     * @param name
     * @param blocks
     */
    public MapEntity(String name, TextureEntity[][] blocks){
        this.name = name;
        this.blocks = blocks;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
