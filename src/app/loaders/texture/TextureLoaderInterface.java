package app.loaders.texture;

import app.config.interfaces.ConfigInterface;
import app.entities.TextureEntity;

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
     * Mtoda opowiedzialna za zwracanie obiektu konfiguracyjnego
     */
    public ConfigInterface getConfig();

}
