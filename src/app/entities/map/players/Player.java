package app.entities.map.players;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Player extends MapObject {

    public Integer positionX;
    public Integer positionY;
    public Integer angle;

    public Integer getCoordinateX(){
        return positionX/32;
    }
    public Integer getCoordinateY(){
        return positionY/32;
    }

    @Override
    public Boolean isOpaque() { return false; }

    @Override
    public Boolean isDestructible() { return true; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("PlayerTank");
    }
}
