package app.loaders.texture;

import app.config.interfaces.ConfigInterface;
import app.entities.TextureEntity;

import java.awt.*;
import java.io.IOException;

/**
 * Interfejs ładowania tekstur
 */
public interface TextureLoaderInterface {

    /**
     * Metoda odpowiadajaca za ładowanie tekstury
     * @param name
     * @param path
     */
    public void load(String name, String path);

    /**
     * Metoda odpowiadajaca za ładowanie wszystki tekstur
     */
    public void loadAll();

    /**
     * Laduje wszyskie tekstury z pliku konfiguracyjnego
     * @param config
     */
    public void loadAllBasedOnConfig(ConfigInterface config);

    /**
     * Mtoda opowiedzialna za zwracanie obrazu
     */
    public TextureEntity get(String name);

}
