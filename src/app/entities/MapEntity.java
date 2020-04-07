package app.entities;

import java.awt.*;

/**
 * Obiekt rezprezentujący encję mapy
 */
public class MapEntity {
    /**
     * Nazwa mapy
     */
    public String name;

    /**
     * Bloki mapy
     */
    public TextureEntity[][] blocks;

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
}
