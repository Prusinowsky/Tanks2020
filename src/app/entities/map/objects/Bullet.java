package app.entities.map.objects;

import app.Container;
import app.entities.TextureEntity;
import app.entities.map.MapObject;

public class Bullet extends MapObject {

    public Integer angle;
    public Class team;

    public Integer getDirectionX(){
        if(this.angle == 90)
            return 1;
        if(this.angle == 270)
            return -1;
        return 0;
    }

    public Integer getDirectionY(){
        if(this.angle == 180)
            return 1;
        if(this.angle == 0)
            return -1;
        return 0;
    }

    @Override
    public Boolean isOpaque() { return false; }

    @Override
    public Boolean isDestructible() { return false; }

    @Override
    public Boolean isPortal() { return false; }

    @Override
    public TextureEntity getTexture() {
        return Container.getInstance().provideTextureLoader().getTexture("Bullet");
    }
}
