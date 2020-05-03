package app.entities.map.obstacles;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class DestructibleObstacle extends MapObject {

    @Override
    public Boolean isOpaque() { return true; }

    @Override
    public Boolean isDestructible() { return true; }

    @Override
    public Boolean isPortal() { return false; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture(
                Container.getInstance().provideConfig().getProperty("map_destructible_" + mapCode)
        );
    }

}
