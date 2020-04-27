package app.engine;

import app.entities.map.MapEntity;
import app.entities.map.MapLayer;
import app.loaders.texture.TextureLoader;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EngineRender {

    private Image offscreen;
    private MapEntity mapEntity;
    private TextureLoader textureLoader;

    private GameScreenComponent gameScreenComponent;
    private GameHudComponent gameHudComponent;

    private Integer x = 0;
    private Integer y = 0;

    public EngineRender(){
        init();
    }

    public void init(){
        this.textureLoader = (TextureLoader) app.Container.getInstance().provideTextureLoader();
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

    public void setPlayers(){

    }

    public void setEnemies(){

    }

    public void render(){
        if(offscreen != null && mapEntity != null) {
            Graphics2D g2d = (Graphics2D) offscreen.getGraphics();
            g2d.clearRect(0,0, offscreen.getWidth(null), offscreen.getHeight(null));

            x += 20; x %= 500;
            y += 20; y %= 500;

            g2d.drawString("Michu zrobisz to?", x, y);

            for(Integer i = 0; i < mapEntity.numberOfLayers; i++){
                renderLayer(g2d, mapEntity.layers[i]);
            }

        }
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
        gameScreenComponent.setScreen(offscreen);
        gameScreenComponent.revalidate();
        gameScreenComponent.repaint();
    };

}
