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

    public Integer getCoordinateX(){
        return positionX/32;
    }
    public Integer getCoordinateY(){
        return positionY/32;
    }

    public abstract Boolean isOpaque();
    public abstract Boolean isDestructible();
    public abstract TextureEntity getTexture();
}
