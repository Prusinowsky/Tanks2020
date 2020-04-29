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
     * @param name nazwa tekstury
     * @param path ścieżka tekstury
     */
    public void loadTexture(String name, String path);

    /**
     * Metoda opowiedzialna za zwracanie tekstury
     * @param name nazwa tesktury
     * @return encja tekstury
     */
    public TextureEntity getTexture(String name);

    /**
     * Zwraca obraz tekstury
     * @param name nazwa tekstury
     * @return obraz tekstury
     */
    public Image getTextureImage(String name);

    /**
     * Metoda odpowiedzialna za zwracanie przeskalowanego obrazu tekstury
     * @param name nazwa
     * @param width szerokość
     * @param height wysokość
     * @param hints wskazówka
     * @return przeskalowany obraz
     */
    public Image getTextureImageScaled(String name, Integer width, Integer height, Integer hints);

    /**
     * Metoda opowiedzialna za zwracanie obiektu konfiguracyjnego
     * @return Obiekt konfiguracyjny
     */
    public ConfigInterface getConfig();
}
