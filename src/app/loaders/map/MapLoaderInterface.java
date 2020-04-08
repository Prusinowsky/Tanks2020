package app.loaders.map;

import app.config.interfaces.ConfigInterface;
import app.entities.MapEntity;
import app.entities.TextureEntity;

import java.util.HashMap;

/**
 * Interfejs ladowania map
 */
public interface MapLoaderInterface {

    /**
     * Meotda ładująca mapę
     * @param config
     */
    public void load(ConfigInterface config);

    /**
     * Przekształcająca wybraną mapę
     * @return
     */
    public MapEntity convertToMapEntity(String name, String path, HashMap<Integer, TextureEntity> mapPattern);

}
