package app.entities.map;

import app.entities.TextureEntity;

/**
 * Absrakcjas opisujący obiekty na mapie
 */
public abstract class MapObject {
    public Integer code;
    public Integer mapCode;
    public String mapName;

    public abstract TextureEntity getTexture();
}
