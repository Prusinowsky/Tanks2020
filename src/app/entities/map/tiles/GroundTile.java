package app.entities.map.tiles;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class GroundTile extends MapObject {

    @Override
    public Boolean isOpaque() { return false; }

    @Override
    public Boolean isDestructible() { return false; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture(
                Container.getInstance().provideConfig().getProperty("map_ground_" + mapCode)
        );
    }
}
