package app.entities;

import javax.swing.*;
import java.awt.*;

/**
 * Encja tekstury
 */
public class TextureEntity implements Cloneable {
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
     * Obraz
     */
    public ImageIcon imageIcon;

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
        this.imageIcon = new ImageIcon(image);
    }


        /*  put się nie przyda, ale reszta już tak XD, tu będzie jakiś if związany z typem
        pattern.put(0, textureLoader.getTexture(config.getProperty("map_ground_" + i)));
        pattern.put(1, textureLoader.getTexture(config.getProperty("map_destructible_" + i)));
        pattern.put(2, textureLoader.getTexture(config.getProperty("map_destroyed_" + i)));
        pattern.put(3, textureLoader.getTexture(config.getProperty("map_indestructible_" + i)));
        pattern.put(4, textureLoader.getTexture("Portal"));
     */


    @Override
    public Object clone() throws CloneNotSupportedException {
        TextureEntity copied = (TextureEntity)super.clone();
        return copied;
    }
}
