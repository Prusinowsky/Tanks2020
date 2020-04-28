package app.entities.map.players;


import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Enemy extends MapObject {

    public Integer positionX;
    public Integer positionY;
    public Integer angle;


    @Override
    public Boolean isBlock() { return false; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("EnemyTank");
    }
}
