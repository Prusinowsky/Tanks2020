package app.entities.map;

import app.entities.TextureEntity;

/**
 * Absrakcjas opisujący obiekty na mapie
 */
public abstract class MapObject {
    public Integer code; // 1,2,3,4,5
    public Integer mapCode; // 0 - dolina
    public String mapName; // Dolina

    public Integer positionX = 0;
    public Integer positionY = 0;

    /**
     * Koordynaty X
     * @return Koordynata X
     */
    public Integer getCoordinateX(){
        return positionX/32;
    }

    /**
     * Koordynata Y
     * @return Koordynata Y
     */
    public Integer getCoordinateY(){
        return positionY/32;
    }

    /**
     * Sprawdza czy obiekty są na tej samej pozycji
     * @param object Obiekt
     * @return Boolen
     */
    public Boolean isOnTheSameCoordinate(MapObject object){
        return object != null
                && getCoordinateX() == object.getCoordinateX()
                && getCoordinateY() == object.getCoordinateY();
    }

    /**
     * Metoda sprawdzająca czy obiekt jest nieprzezroczycty
     * @return Boolean
     */
    public abstract Boolean isOpaque();

    /**
     * Metoda sprawdzająca czy obiekt jest zniszczlnay
     * @return Boolean
     */
    public abstract Boolean isDestructible();

    /**
     * Zwraca teksturę obiektu
     * @return Encja tekstury
     */
    public abstract TextureEntity getTexture();

}
