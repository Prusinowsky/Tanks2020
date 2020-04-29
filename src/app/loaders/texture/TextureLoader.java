package app.loaders.texture;

import app.Container;
import app.config.ConfigInterface;
import app.entities.TextureEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Obkiet odpowiadajacy za ładowanie tekstur
 */
public class TextureLoader implements TextureLoaderInterface {
    private ConfigInterface config;
    public HashMap <String, TextureEntity> collection = new HashMap<String, TextureEntity>();

    /**
     * Konstruktor domyślny
     */
    public TextureLoader(){
        Container container = Container.getInstance();
        config = container.provideConfig();
    }

    /**
     * Konstrukor z ładowaniem
     * @param config Obiekt konfiguracyjny
     */
    public TextureLoader(ConfigInterface config){
        this.config = config;
    }

    /**
     * Laduje wszyskie tekstury z pliku konfiguracyjnego
     */
    public void load(){
        Integer number = Integer.parseInt(config.getProperty("texture_number"));
        String texturePath = config.getProperty("textures_path");
        for(Integer i = 0; i < number; i++){
            String name = config.getProperty("texture_name_"+i);
            String path = texturePath + config.getProperty("texture_path_"+i);
            loadTexture(name, path);
        }
    }


    /**
     * Metoda odpowiadajaca za ładowanie tekstury
     * @param name nazwa tekstury
     * @param path ścieżka tekstury
     */
    public void loadTexture(String name, String path) {

        try {
            File pathToFile = new File(path);
            Image image = ImageIO.read(pathToFile);
            collection.put(name, new TextureEntity(name, path, image));
        } catch (IOException e){
            System.out.println("Error - " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error - " + e.getLocalizedMessage());
        }

    }

    /**
     * Zwraca teksture znajdujaca sie po dana nazwa
     * @param name nazwa tekstury
     * @return Encja tekstury
     */
    public TextureEntity getTexture(String name){
        return collection.get(name);
    }

    /**
     * Zwraca obraz tekstury
     * @param name nazwa tekstury
     * @return Obraz tesktury
     */
    public Image getTextureImage(String name) {
        return getTexture(name).image;
    }

    /**
     * Zwraca przeskalowany obraz tekstury
     * @param name nazwa
     * @param width szerokość
     * @param height wyskosć
     * @param hints wskazówka
     * @return Przeskalowany orbaz
     */
    public Image getTextureImageScaled(String name, Integer width, Integer height, Integer hints){
        return getTexture(name).image.getScaledInstance(width, height, hints);
    }


    /**
     * Mtoda opowiedzialna za zwracanie obiektu konfiguracyjnego
     */
    public ConfigInterface getConfig(){
        return config;
    };
}
