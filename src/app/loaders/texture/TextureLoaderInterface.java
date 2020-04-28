package app.loaders.texture;

import app.config.ConfigInterface;
import app.entities.TextureEntity;

import java.awt.*;

/**
 * Interfejs ładowania tekstur
 */
public interface TextureLoaderInterface {

    /**
     * Metoda odpowiadajaca za ładowanie wszystki tekstur
     */
    public void load();

    /**
     * Metoda odpowiadajaca za ładowanie tekstury
     * @param name
     * @param path
     */
    public void loadTexture(String name, String path);

    /**
     * Mtoda opowiedzialna za zwracanie obrazu
     */
    public TextureEntity getTexture(String name);

    /**
     * Zwraca obraz tekstury
     * @param name
     * @return
     */
    public Image getTextureImage(String name);

    /**
     * Metoda odpowiedzialna za zwracanie przeskalowanego obrazu tekstury
     * @param name
     * @param width
     * @param height
     * @param hints
     * @return
     */
    public Image getTextureImageScaled(String name, Integer width, Integer height, Integer hints);

    /**
     * Mtoda opowiedzialna za zwracanie obiektu konfiguracyjnego
     */
    public ConfigInterface getConfig();
}
