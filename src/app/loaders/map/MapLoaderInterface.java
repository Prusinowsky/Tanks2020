package app.loaders.map;

import app.entities.MapEntity;
import app.entities.map.MapObjectInterface;

import java.util.HashMap;

/**
 * Interfejs ladowania map
 */
public interface MapLoaderInterface {

    /**
     * Meotda ładująca mapę
     */
    public void load();

    /**
     * Przekształcająca wybraną mapę
     * @return
     */
    public MapEntity convertToMapEntity(String name, String path, HashMap<Integer, MapObjectInterface> mapPattern);

    /**
     * Zwaraca mape o danej nazwie
     * @param name
     * @return
     */
    public MapEntity getMap(String name);
}
