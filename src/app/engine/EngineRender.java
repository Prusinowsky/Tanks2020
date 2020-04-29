package app.engine;

import app.entities.map.MapLayer;
import app.loaders.texture.TextureLoader;
import app.display.components.GameHudComponent;
import app.display.components.GameScreenComponent;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Obiekt odpowiedzialny za renderowanie gry
 */
public class EngineRender {

    private Engine engine;

    private Image offscreen, screen;
    private TextureLoader textureLoader;

    private GameScreenComponent gameScreenComponent;
    private GameHudComponent gameHudComponent;


    public EngineRender(Engine engine){
        this.engine = engine;
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

    public void render(){
        if(offscreen != null && engine.map != null) {
            offscreen = new BufferedImage(16*32, 16*32, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) offscreen.getGraphics();
            g2d.clearRect(0,0, offscreen.getWidth(null), offscreen.getHeight(null));

            for(Integer i = 0; i < engine.map.numberOfLayers; i++){
                renderLayer(g2d, engine.map.layers[i]);
            }
            renderPlayer(g2d);
            renderBullets(g2d);
            renderEnemies(g2d);
        }
        screen = offscreen;
    }

    private void renderPlayer(Graphics2D g2d){
        Image playerImg = engine.player.getTexture().image;
        Image playerBuffored = new BufferedImage(playerImg.getWidth(null), playerImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D player2d = ((BufferedImage) playerBuffored).createGraphics();
        player2d.rotate(Math.toRadians(engine.player.angle), playerImg.getWidth(null) >> 1, playerImg.getHeight(null) >> 1);
        player2d.drawImage(playerImg,0,0,null);
        g2d.drawImage(playerBuffored, engine.player.positionX, engine.player.positionY,null);
    }

    private void renderBullets(Graphics2D g2d){
        Integer number = engine.bullets.size();
        for(Integer i=0; i<number; i++) {
            Image bulletImg = engine.bullets.get(i).getTexture().image;
            Image bulletBuffored = new BufferedImage(bulletImg.getWidth(null), bulletImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D bullet2d = ((BufferedImage) bulletBuffored).createGraphics();
            bullet2d.rotate(Math.toRadians(engine.bullets.get(i).angle), bulletImg.getWidth(null) >> 1, bulletImg.getHeight(null) >> 1);
            bullet2d.drawImage(bulletImg, 0, 0, null);
            g2d.drawImage(bulletBuffored, engine.bullets.get(i).positionX, engine.bullets.get(i).positionY, null);
        }
    }

    private void renderEnemies(Graphics2D g2d){
        Integer number = engine.enemies.size();
        for(Integer i=0; i<number; i++) {
            Image enemyImg = engine.enemies.get(i).getTexture().image;
            Image enemyBuffored = new BufferedImage(enemyImg.getWidth(null), enemyImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D enemy2d = ((BufferedImage) enemyBuffored).createGraphics();
            enemy2d.rotate(Math.toRadians(engine.enemies.get(i).angle), enemyImg.getWidth(null) >> 1, enemyImg.getHeight(null) >> 1);
            enemy2d.drawImage(enemyImg, 0, 0, null);
            g2d.drawImage(enemyBuffored, engine.enemies.get(i).positionX, engine.enemies.get(i).positionY, null);
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
        gameScreenComponent.setScreen(screen);
        gameScreenComponent.revalidate();
        gameScreenComponent.repaint();
    };

}
