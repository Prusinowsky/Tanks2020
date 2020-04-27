package app.engine;

import app.entities.map.players.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.players.Player;
import app.loaders.map.MapLoaderInterface;
import app.loaders.texture.TextureLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Engine implements EngineInterface {

    private Image screen;

    private Integer score;
    private String playerName;

    private Player player;
    private Enemy[] enemies;
    private MapEntity map;

    private TextureLoader textureLoader;
    private MapLoaderInterface mapLoader;

    public Engine(){
        screen = new BufferedImage(16*32, 16*32, BufferedImage.TYPE_INT_ARGB);

        textureLoader = (TextureLoader) app.Container.getInstance().provideTextureLoader();
        mapLoader = app.Container.getInstance().provideMapLoader();
    }

    @Override
    public void startGame() {
        map = mapLoader.getMap(app.Container.getInstance().provideOptions().mapName);
        renderMap();
    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void endGame() {

    }

    public void renderMap(){
        Integer gridX = 16;
        Integer gridY = 16;

        Graphics2D g2 = (Graphics2D) screen.getGraphics();

        Integer sWidth = screen.getWidth(null)/gridX;
        Integer sHeight = screen.getHeight(null)/gridY;

       for(Integer j=0; j < gridX; j++)
        {
            for(Integer i=0; i < gridY; i++)
            {
                //Image scaled = map.blocks[i][j].image.getScaledInstance(sWidth, sHeight, Image.SCALE_DEFAULT);
                //g2.drawImage(scaled,  sWidth*i, sHeight*j, null);
            }
        }

        g2.drawImage(textureLoader.getTexture("EnemyTank").image,  0,0, sWidth, sHeight, null);
    }

    public Image getImageScreen(){
        return screen;
    }

}
