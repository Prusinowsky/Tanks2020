package app.entities.map.obstacles;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class DestructibleObstacle extends MapObject {

    @Override
    public Boolean isBlock() { return true; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture(
                Container.getInstance().provideConfig().getProperty("map_destructible_" + mapCode)
        );
    }

}
