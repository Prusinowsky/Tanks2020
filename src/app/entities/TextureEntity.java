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
     * @param name nazwa tesktury
     * @param path nazwa ścieżki
     * @param image przypisywany obraz
     */
    public TextureEntity(String name, String path, Image image){
        this.name = name;
        this.path = path;
        this.image = image;
        this.imageIcon = new ImageIcon(image);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TextureEntity copied = (TextureEntity)super.clone();
        return copied;
    }
}
