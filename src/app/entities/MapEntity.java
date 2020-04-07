package app.entities;

import java.awt.*;

/**
 * Obiekt rezprezentujący encję mapy
 */
public class MapEntity {
    protected String name;
    protected String path;
    protected TextureEntity texture;

    /**
     * Konstrukor domyślny
     */
    public MapEntity(){}

    /**
     * Konstrukotr inicjalizujący z parametrami
     * @param name
     * @param path
     */
    public MapEntity(String name, String path){
        // TODO: 07.04.2020
    }

    /**
     *
     * @param name nazwa encji
     * @param path ścieżka do pliku
     */
    public void load(String name, String path) {
        // TODO: 07.04.2020
    }
}
