package app.engine;

import app.engine.interfaces.EngineInterface;
import app.entities.map.players.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.players.Player;
import app.loaders.map.MapLoaderInterface;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Engine implements EngineInterface {

    private EngineRender engineRender;
    private Timer timer;

    private Integer score;
    private String playerName;

    private Player player;
    private Enemy[] enemies;
    private MapEntity map;

    private MapLoaderInterface mapLoader;

    public Engine(){
        mapLoader = app.Container.getInstance().provideMapLoader();
        initEngineRender();
    }

    private void initEngineRender(){
        this.engineRender = new EngineRender();
    }

    @Override
    public void startGame() {
        map = mapLoader.getMap(app.Container.getInstance().provideOptions().mapName);

        player = new Player();
        player.positionX = 0;
        player.positionY = 0;
        player.angle = 0;
        engineRender.setPlayer(player);

        engineRender.setMapEntity(map);

        timer = new Timer();
        renderWithFreq(120);
    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void endGame() {
        timer.cancel();
    }

    private void renderWithFreq(Integer fps){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                render();
            }
        }, 1000/fps , 1000 / fps);
    }

    private void render(){
        engineRender.render();
        engineRender.update();
    }

    public void moveUp(){
        player.positionY -= 4;
        player.angle = 0;
    }

    public void moveDown(){
        player.positionY += 4;
        player.angle = 180;
    }

    public void moveRight(){
        player.positionX += 4;
        player.angle = 90;
    }

    public void moveLeft(){
        player.positionX -= 4;
        player.angle = 270;
    }

    public void setGameScreenComponent(GameScreenComponent gameScreenComponent){
        engineRender.setGameScreenComponent(gameScreenComponent);
    }

    public void setGameHudComponent(GameHudComponent gameHudComponent){
        engineRender.setGameHudComponent(gameHudComponent);
    }

}
