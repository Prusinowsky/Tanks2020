package app.entities.map;

import app.entities.TextureEntity;

import java.awt.*;

public interface MapObjectInterface {
    public TextureEntity getTexture(Integer textureType);
    public Integer getPositionX();
    public Integer getPositionY();

}
