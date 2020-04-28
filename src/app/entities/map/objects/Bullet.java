package app.entities.map.objects;

import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Bullet extends MapObject {

    @Override
    public Boolean isBlock() { return false; }

    @Override
    public TextureEntity getTexture() {
        return null;
    }
}
