package app.entities.map.tanks;

import app.Container;
import app.entities.TextureEntity;

public class Player extends AbstractTank {

    @Override
    public Boolean isOpaque() { return true; }

    @Override
    public Boolean isDestructible() { return true; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("PlayerTank");
    }
}
