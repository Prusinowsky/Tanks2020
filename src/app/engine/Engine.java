package app.engine;

import app.engine.interfaces.EngineInterface;
import app.entities.map.objects.Bullet;
import app.entities.map.players.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.players.Player;
import app.loaders.map.MapLoaderInterface;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Engine implements EngineInterface {

    private EngineRender engineRender;
    private Timer timer;

    private Integer score;
    private String playerName;

    private Player player;
    private Enemy[] enemies;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
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

        engineRender.setBullets(bullets);

        engineRender.setMapEntity(map);

        timer = new Timer();
        renderWithFreq(30);
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
        if(player.getCordinateY()-1>=0 && player.getCordinateY()-1 < map.height)
            if(map.layers[1].blocks[player.getCordinateX()][player.getCordinateY()-1] == null){
                player.positionY -= 32;
                player.angle = 0;
            }
            else if(map.layers[1].blocks[player.getCordinateX()][player.getCordinateY()-1].isBlock() == false) {
                player.positionY -= 32;
                player.angle = 0;
            }
            else player.angle = 0;
    }

    public void moveDown(){
        if(player.getCordinateY()+1>=0 && player.getCordinateY()+1 < map.height)
            if(map.layers[1].blocks[player.getCordinateX()][player.getCordinateY()+1] == null){
                player.positionY += 32;
                player.angle = 180;
            }
            else if(map.layers[1].blocks[player.getCordinateX()][player.getCordinateY()+1].isBlock() == false) {
                player.positionY += 32;
                player.angle = 180;
            }
            else player.angle = 180;
    }

    public void moveRight(){
        if(player.getCordinateX()+1>=0 && player.getCordinateX()+1 < map.width)
            if(map.layers[1].blocks[player.getCordinateX()+1][player.getCordinateY()] == null){
                player.positionX += 32;
                player.angle = 90;
            }
            else if(map.layers[1].blocks[player.getCordinateX()+1][player.getCordinateY()].isBlock() == false) {
                player.positionX += 32;
                player.angle = 90;
            }
            else player.angle = 90;
    }

    public void moveLeft(){
        if(player.getCordinateX()-1>=0 && player.getCordinateX()-1 < map.width)
            if(map.layers[1].blocks[player.getCordinateX()-1][player.getCordinateY()] == null){
                player.positionX -= 32;
                player.angle = 270;
            }
            else if(map.layers[1].blocks[player.getCordinateX()-1][player.getCordinateY()].isBlock() == false) {
                player.positionX -= 32;
                player.angle = 270;
            }
            else player.angle = 270;
    }

    public void shoot() {
        bullets.add(new Bullet());
        Integer number = bullets.size();
        bullets.get(number-1).positionX = player.positionX;
        bullets.get(number-1).positionY = player.positionY;
        bullets.get(number-1).angle = player.angle;

        /*if (bullets.get(number-1).angle == 0) {
            while (map.layers[1].blocks[bullets.get(number-1).getCordinateX()][bullets.get(number-1).getCordinateY() - 1] == null &&
                    map.layers[1].blocks[bullets.get(number-1).getCordinateX()][bullets.get(number-1).getCordinateY() - 1].isBlock() == false &&
                    (bullets.get(number-1).getCordinateY() - 1 >= 0 && bullets.get(number-1).getCordinateY() - 1 < map.height) )  {
                bullets.get(number-1).positionY -= 32;
                System.out.println("up");
            }
        } else if (bullets.get(number-1).angle == 90) {
            while (map.layers[1].blocks[bullets.get(number-1).getCordinateX() + 1][bullets.get(number-1).getCordinateY()] == null &&
                    map.layers[1].blocks[bullets.get(number-1).getCordinateX() + 1][bullets.get(number-1).getCordinateY()].isBlock() == false &&
                    (bullets.get(number-1).getCordinateX() + 1 >= 0 && bullets.get(number-1).getCordinateX() + 1 < map.width)) {
                bullets.get(number-1).positionX += 32;
                System.out.println("right");
            }
        } else if (bullets.get(number-1).angle == 180) {
            while (map.layers[1].blocks[bullets.get(number-1).getCordinateX()][bullets.get(number-1).getCordinateY() + 1] == null &&
                    map.layers[1].blocks[bullets.get(number-1).getCordinateX()][bullets.get(number-1).getCordinateY() + 1].isBlock() == false &&
                    (bullets.get(number-1).getCordinateY() + 1 >= 0 && bullets.get(number-1).getCordinateY() + 1 < map.width)) {
                bullets.get(number-1).positionY += 32;
                System.out.println("down");
            }
        } else if (bullets.get(number-1).angle == 270) {
            while (map.layers[1].blocks[bullets.get(number-1).getCordinateX() - 1][bullets.get(number-1).getCordinateY()] == null &&
                    map.layers[1].blocks[bullets.get(number-1).getCordinateX() - 1][bullets.get(number-1).getCordinateY()].isBlock() == false &&
                    (bullets.get(number-1).getCordinateX() - 1 >= 0 && bullets.get(number-1).getCordinateX() - 1 < map.width)) {
                bullets.get(number-1).positionX -= 32;
                System.out.println("left");
            }
        }*/
    }

    public void bulletMove(){

    }

    public void setGameScreenComponent(GameScreenComponent gameScreenComponent){
        engineRender.setGameScreenComponent(gameScreenComponent);
    }

    public void setGameHudComponent(GameHudComponent gameHudComponent){
        engineRender.setGameHudComponent(gameHudComponent);
    }

}
