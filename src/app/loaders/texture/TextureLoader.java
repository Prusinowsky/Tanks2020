package app.loaders.texture;

import app.config.Config;
import app.config.interfaces.ConfigInterface;
import app.entities.TextureEntity;
import app.loaders.texture.TextureLoaderInterface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Obkiet odpowiadajacy za ładowanie tekstur
 */
public class TextureLoader implements TextureLoaderInterface {

    public HashMap <String, TextureEntity> collection = new HashMap<String, TextureEntity>();

    /**
     * Konstruktor domyślny
     */
    public TextureLoader(){
    }


    /**
     * Konstrukor z ładowaniem
     * @param name
     * @param path
     */
    public TextureLoader(String name, String path){
        load(name, path);
    }

    /**
     * Metoda odpowiadajaca za ładowanie tekstury
     * @param name
     * @param path
     */
    public void load(String name, String path) {

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
     * Laduje wszyskie tekstury z domyslnego pliku konfiguracyjnego
     */
    public void loadAll(){
        Config config = Config.getInstance();
        loadAllBasedOnConfig(config);
    }

    /**
     * Laduje wszyskie tekstury z pliku konfiguracyjnego
     * @param config
     */
    public void loadAllBasedOnConfig(ConfigInterface config){
        Integer number = Integer.parseInt(config.getProperty("texture_number"));
        String texturePath = config.getProperty("textures_path");
        for(Integer i = 0; i < number; i++){
            String name = config.getProperty("texture_name_"+i);
            String path = texturePath + config.getProperty("texture_path_"+i);
            load(name, path);
        }
    }

    /**
     * Zwraca teksture znajdujaca sie po dana nazwa
     * @param name
     * @return
     */
    public TextureEntity get(String name){
        return collection.get(name);
    }
}
