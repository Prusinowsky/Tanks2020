package app.entities.map.players;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Player extends MapObject {

    public Integer positionX;
    public Integer positionY;
    public Integer angle;

    public Integer getCordinateX(){
        return positionX/32;
    }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("PlayerTank");
    }
}
