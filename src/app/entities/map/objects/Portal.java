package app.entities.map.objects;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Portal extends MapObject  {

    @Override
    public Boolean isOpaque() { return false; }

    @Override
    public Boolean isDestructible() { return false; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("Portal");
    }
}
