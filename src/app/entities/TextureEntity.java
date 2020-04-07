package app.entities;

import java.awt.*;

/**
 * Encja tekstury
 */
public class TextureEntity {
    /**
     * Nazwa
     */
    public String name;

    /**
     * Sciezka
     */
    public String path;

    /**
     * Obraz
     */
    public Image image;

    /**
     * Konstrukor domyślny
     */
    public TextureEntity(){}

    /**
     * Konstrukotr inicjalizujący z parametrami
     * @param name
     * @param path
     */
    public TextureEntity(String name, String path, Image image){
        this.name = name;
        this.path = path;
        this.image = image;
    }
}
