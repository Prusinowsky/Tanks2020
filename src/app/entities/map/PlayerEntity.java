package app.entities.map;

import app.entities.TextureEntity;

public class PlayerEntity implements MapObjectInterface {
    public TextureEntity getTexture(Integer textureType){return null;}
    public Integer getPositionX(){return 0;}
    public Integer getPositionY(){return 0;}
    public void move(){}
    public double getVelocity(){return 0.f;}
}
