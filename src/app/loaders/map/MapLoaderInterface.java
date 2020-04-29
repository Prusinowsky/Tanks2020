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

    /** Przekształcająca wybraną mapę
     * @param mapCode kody mapy
     * @param mapName nazwa mapy
     * @param path ścieżka mapy
     * @return Encja mapy
     */

    public MapEntity convertToMapEntity(Integer mapCode, String mapName, String path);

    /**
     * Zwaraca mape o danej nazwie
     * @param name nazwa mapy
     * @return Encja mapy
     */
    public MapEntity getMap(String name);
}
