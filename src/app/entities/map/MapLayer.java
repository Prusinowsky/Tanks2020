package app.entities.map;

/**
 * Encja odpowiadająca za przetrzymywanie warstwy
 */
public class MapLayer {

    /**
     * Nazwa danej wartstwy
     */
    public String name;

    /**
     * Wysokość i szerokość
     */
    public Integer width, height;

    /**
     * Blokki w wartswie [wysokosc][szerokosc]
     */
    public MapObject[][] blocks;

}
