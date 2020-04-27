package app.engine;

import app.entities.map.MapEntity;
import app.entities.map.MapLayer;
import app.entities.map.players.Player;
import app.loaders.texture.TextureLoader;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EngineRender {

    private Image offscreen, screen;
    private MapEntity mapEntity;
    private TextureLoader textureLoader;
    private Player player;

    private GameScreenComponent gameScreenComponent;
    private GameHudComponent gameHudComponent;


    public EngineRender(){
        init();
    }

    public void init(){
        this.textureLoader = (TextureLoader) app.Container.getInstance().provideTextureLoader();
        screen = new BufferedImage(16*32, 16*32, BufferedImage.TYPE_INT_ARGB);
        offscreen = new BufferedImage(16*32, 16*32, BufferedImage.TYPE_INT_ARGB);
    }

    public void setGameScreenComponent(GameScreenComponent gameScreenComponent){
        this.gameScreenComponent = gameScreenComponent;
        gameScreenComponent.setScreen(offscreen);
    }

    public void setGameHudComponent(GameHudComponent gameHudComponent){
        this.gameHudComponent = gameHudComponent;
    }

    public void setMapEntity(MapEntity map){
        this.mapEntity = map;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setEnemies(){

    }

    public void render(){
        if(offscreen != null && mapEntity != null) {
            offscreen = new BufferedImage(16*32, 16*32, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) offscreen.getGraphics();
            g2d.clearRect(0,0, offscreen.getWidth(null), offscreen.getHeight(null));

            for(Integer i = 0; i < mapEntity.numberOfLayers; i++){
                renderLayer(g2d, mapEntity.layers[i]);
            }
            renderPlayer(g2d);
        }
        screen = offscreen;
    }

    private void renderPlayer(Graphics2D g2d){
        Image playerImg = this.player.getTexture().image;

        //Graphics2D player2d = (new BufferedImage()).createGraphics();
        //player2d.rotate(Math.toRadians(this.player.angle), playerImg.getWidth(null)>>1, playerImg.getHeight(null)>>1);
        //player2d.drawImage(playerImg,0,0,null);
        g2d.drawImage(playerImg, player.positionX, player.positionY,null);
    }

    private void renderLayer(Graphics2D g2d, MapLayer layer){
        for(Integer i = 0; i < layer.height; i++){
            for(Integer j = 0; j < layer.width; j++){
                if(layer.blocks[i][j] != null)
                    g2d.drawImage(layer.blocks[i][j].getTexture().image, i*32, j*32, null);
            }
        }
    }

    public void update(){
        gameScreenComponent.setScreen(screen);
        gameScreenComponent.revalidate();
        gameScreenComponent.repaint();
    };

}
