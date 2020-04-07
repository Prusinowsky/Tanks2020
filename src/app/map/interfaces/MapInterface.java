package app.map.interfaces;

import app.entities.MapEntity;

/**
 * Interfejs obslugi mapy
 */
public interface MapInterface {

    /**
     * Zwraca wszystkie jednostki danej mapy
     * @return
     */
    public MapEntity[][] getAllMapEntities();

    /**
     * Zwraca jednostkę (encje) mapy
     * @param x
     * @param y
     * @return
     */
    public MapEntity getMapEntity(Integer x, Integer y);

}
