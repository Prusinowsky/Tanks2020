package app.engine;

import app.engine.interfaces.EngineInterface;
import app.entities.map.objects.Bullet;
import app.entities.map.players.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.players.Player;
import app.loaders.map.MapLoaderInterface;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Engine implements EngineInterface {

    private EngineRender engineRender;
    private Timer timer;

    private Integer score;
    private String playerName;

    private Player player;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
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

        loadEnemies();

        engineRender.setEnemies(enemies);
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
        handleBulletsBehaviour();
        handleEnemyTanksBehaviour();
        engineRender.render();
        engineRender.update();
    }

    private void handleBulletsBehaviour(){
        for(Integer i=0; i<bullets.size(); i++){
            handleSingleBulletBehaviour(bullets.get(i));
        }
    }

    private void handleSingleBulletBehaviour(Bullet bullet){
        moveSingleBullet(bullet);
        destroyObstacle(bullet);
        destroyEnemyTank(bullet);
    }

    private void moveSingleBullet(Bullet bullet){
        if(bullet.angle == 0){
            bullet.positionY -= 4;
        }
        else if(bullet.angle == 90){
            bullet.positionX += 4;
        }
        else if(bullet.angle == 180){
            bullet.positionY += 4;
        }
        else if(bullet.angle == 270){
            bullet.positionX -= 4;
        }
    }

    private void destroyObstacle(Bullet bullet){
        if(!(bullet.getCoordinateY()>=0 && bullet.getCoordinateY() < map.height && bullet.getCoordinateX()>=0 && bullet.getCoordinateX() < map.width)){
            bullets.remove(bullet);
        }
        else if(map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()] != null &&
                map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()].isOpaque()){
            if(map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()].isDestructible()) {
                map.layers[1].blocks[bullet.getCoordinateX()][bullet.getCoordinateY()] = null;
                bullets.remove(bullet);
            }
            else {
                bullets.remove(bullet);
            }
        }
    }

    //NIEZROBIONE!!!
    private void destroyEnemyTank(Bullet bullet){
        if(!(bullet.getCoordinateY()>=0 && bullet.getCoordinateY() < map.height && bullet.getCoordinateX()>=0 && bullet.getCoordinateX() < map.width)){
            bullets.remove(bullet);
        }
    }

    private void handleEnemyTanksBehaviour(){
        for(Integer i=0; i<enemies.size(); i++){
            handleSingleEnemyTankBehaviour(enemies.get(i));
        }
    }

    private void handleSingleEnemyTankBehaviour(Enemy enemy){
        moveSingleEnemyTank(enemy);
    }

    private void moveSingleEnemyTank(Enemy enemy){
        if(enemy.angle == 0) moveUpSingleEnemyTank(enemy);
        if(enemy.angle == 90) moveRightSingleEnemyTank(enemy);
        if(enemy.angle == 180) moveDownSingleEnemyTank(enemy);
        if(enemy.angle == 270) moveLeftSingleEnemyTank(enemy);
    }

    private void moveUpSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateY()-1>=0 && enemy.getCoordinateY()-1 < map.height) {
            if (map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1] == null) {
                enemy.positionY -= 32;
                enemy.angle = 0;
            }else if (!map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() - 1].isOpaque()) {
                enemy.positionY -= 32;
                enemy.angle = 0;
            } else {
                enemy.angle = 180;
            }
        }
    }

    private void moveRightSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateX()+1>=0 && enemy.getCoordinateX()+1 < map.width) {
            if (map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()] == null) {
                enemy.positionX += 32;
                enemy.angle = 90;
            } else if (!map.layers[1].blocks[enemy.getCoordinateX() + 1][enemy.getCoordinateY()].isOpaque()) {
                enemy.positionX += 32;
                enemy.angle = 90;
            } else {
                enemy.angle = 270;
            }
        }
    }

    private void moveDownSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateY()+1>=0 && enemy.getCoordinateY()+1 < map.height) {
            if (map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1] == null) {
                enemy.positionY += 32;
                enemy.angle = 180;
            } else if (!map.layers[1].blocks[enemy.getCoordinateX()][enemy.getCoordinateY() + 1].isOpaque()) {
                enemy.positionY += 32;
                enemy.angle = 180;
            } else {
                enemy.angle = 0;
            }
        }
    }

    private void moveLeftSingleEnemyTank(Enemy enemy){
        if(enemy.getCoordinateX()-1>=0 && enemy.getCoordinateX()-1 < map.width) {
            if (map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()] == null) {
                enemy.positionX -= 32;
                enemy.angle = 270;
            } else if (!map.layers[1].blocks[enemy.getCoordinateX() - 1][enemy.getCoordinateY()].isOpaque()) {
                enemy.positionX -= 32;
                enemy.angle = 270;
            } else {
                enemy.angle = 90;
            }
        }
    }

    public void moveUp(){
        if(player.getCoordinateY()-1>=0 && player.getCoordinateY()-1 < map.height)
            if(map.layers[1].blocks[player.getCoordinateX()][player.getCoordinateY()-1] == null){
                player.positionY -= 32;
                player.angle = 0;
            }
            else if(!map.layers[1].blocks[player.getCoordinateX()][player.getCoordinateY() - 1].isOpaque()) {
                player.positionY -= 32;
                player.angle = 0;
            }
            else player.angle = 0;
    }

    public void moveDown(){
        if(player.getCoordinateY()+1>=0 && player.getCoordinateY()+1 < map.height)
            if(map.layers[1].blocks[player.getCoordinateX()][player.getCoordinateY()+1] == null){
                player.positionY += 32;
                player.angle = 180;
            }
            else if(!map.layers[1].blocks[player.getCoordinateX()][player.getCoordinateY() + 1].isOpaque()) {
                player.positionY += 32;
                player.angle = 180;
            }
            else player.angle = 180;
    }

    public void moveRight(){
        if(player.getCoordinateX()+1>=0 && player.getCoordinateX()+1 < map.width)
            if(map.layers[1].blocks[player.getCoordinateX()+1][player.getCoordinateY()] == null){
                player.positionX += 32;
                player.angle = 90;
            }
            else if(!map.layers[1].blocks[player.getCoordinateX() + 1][player.getCoordinateY()].isOpaque()) {
                player.positionX += 32;
                player.angle = 90;
            }
            else player.angle = 90;
    }

    public void moveLeft(){
        if(player.getCoordinateX()-1>=0 && player.getCoordinateX()-1 < map.width)
            if(map.layers[1].blocks[player.getCoordinateX()-1][player.getCoordinateY()] == null){
                player.positionX -= 32;
                player.angle = 270;
            }
            else if(!map.layers[1].blocks[player.getCoordinateX() - 1][player.getCoordinateY()].isOpaque()) {
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
    }

    public void loadEnemies(){
        Enemy enemy1 = new Enemy(); //testEnemy
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        enemy1.positionX = 192;
        enemy1.positionY = 0;
        enemy1.angle = 180;
        enemy2.positionX = 416;
        enemy2.positionY = 32;
        enemy2.angle = 270;
        enemy3.positionX = 0;
        enemy3.positionY = 224;
        enemy3.angle = 0;
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
    }

    public void setGameScreenComponent(GameScreenComponent gameScreenComponent){
        engineRender.setGameScreenComponent(gameScreenComponent);
    }

    public void setGameHudComponent(GameHudComponent gameHudComponent){
        engineRender.setGameHudComponent(gameHudComponent);
    }

}
