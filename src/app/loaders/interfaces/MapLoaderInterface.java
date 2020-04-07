package app.loaders.interfaces;

import app.config.interfaces.ConfigInterface;
import app.map.interfaces.MapInterface;

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
     * Przekształcająca mapę
     * @return
     */
    public MapInterface[] convertToMaps();

    /**
     * Przekształcająca wybraną mapę
     * @return
     */
    public MapInterface convertToMap(String name);

}
