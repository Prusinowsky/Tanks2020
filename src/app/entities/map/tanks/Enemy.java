package app.entities.map.tanks;


import app.Container;
import app.entities.TextureEntity;

public class Enemy extends AbstractTank {

    @Override
    public Boolean isOpaque() { return false; }

    @Override
    public Boolean isDestructible() { return true; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("EnemyTank");
    }
}
