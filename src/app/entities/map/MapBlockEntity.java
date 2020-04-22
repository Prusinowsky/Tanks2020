package app.entities.map;

import app.entities.TextureEntity;

public class MapBlockEntity implements MapObjectInterface {

    public TextureEntity texture;
    public enum BlockType {
        DESTRUCTIBLE,
        DESTROYED,
        UNDESTRUCTIBLE
    }

    public MapBlockEntity(BlockType blockType){
        if(blockType==BlockType.DESTRUCTIBLE){
            getTexture(1);
        }
        else if(blockType==BlockType.DESTROYED){
            getTexture(2);
        }
        else if(blockType==BlockType.UNDESTRUCTIBLE){
            getTexture(3);
        }
    }

    public TextureEntity getTexture(Integer textureType){return null;}
    public Integer getPositionX(){return 0;}
    public Integer getPositionY(){return 0;}
    public void destroy(){}
    public void isDestroyed(){}

}
