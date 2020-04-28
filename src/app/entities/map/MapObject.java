package app.entities.map;

import app.entities.TextureEntity;

/**
 * Absrakcjas opisujący obiekty na mapie
 */
public abstract class MapObject {
    public Integer code; // 1,2,3,4,5
    public Integer mapCode; // 0 - dolina
    public String mapName; // Dolina

    public abstract Boolean isOpaque();
    public abstract Boolean isDestructible();
    public abstract TextureEntity getTexture();
}
