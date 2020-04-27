package app.loaders.map;

import app.entities.map.MapEntity;

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
    public MapEntity convertToMapEntity(String name, String path);

    /**
     * Zwaraca mape o danej nazwie
     * @param name
     * @return
     */
    public MapEntity getMap(String name);
}
