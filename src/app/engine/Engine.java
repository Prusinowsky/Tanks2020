package app.engine;

import app.Container;
import app.engine.interfaces.EngineInterface;
import app.entities.map.MapLayer;
import app.entities.map.MapObject;
import app.entities.map.objects.Bullet;
import app.entities.map.objects.EnemyBullet;
import app.entities.map.tanks.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.tanks.Player;
import app.loaders.map.MapLoaderInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Silnik gry
 */
public class Engine implements EngineInterface {

    public EngineDriver driver;
    public EnginePhysics physics;
    public EngineRender render;

    public Timer timer;

    public Integer score = 100;
    public Integer lifes = 3;
    public String playerName = "";

    public Long startTime;

    public Player player;
    public MapEntity map;
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public ArrayList<EnemyBullet> enemyBullets = new ArrayList<EnemyBullet>();
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private MapLoaderInterface mapLoader;

    /**
     * Konstrukor dymyslny
     */
    public Engine(){
        init();
    }

    /**
     * Meotda inicjalizujaca silnik
     */
    private void init(){

        this.driver = new EngineDriver(this);
        this.physics = new EnginePhysics(this);
        this.render = new EngineRender(this);
    }

    /**
     * Rozpoczecie gry
     */
    @Override
    public void startGame() {
        this.startTime = new Date().getTime();
        mapLoader = app.Container.getInstance().provideMapLoader();
        map = mapLoader.getMap(app.Container.getInstance().provideOptions().mapName);
        playerName = !Container.getInstance().provideOptions().nickname.isEmpty() ? Container.getInstance().provideOptions().nickname : "Player Tank";

        player = new Player();
        player.positionX = 0;
        player.positionY = 0;
        player.angle = 0;

        loadTanks();

        timer = new Timer();
        renderWithFreq(60);
    }

    public void loadTanks(){
        enemies.clear();
        if(map.code == 0) map1Tanks();
        else if(map.code == 1) map2Tanks();
        else if(map.code == 2) map3Tanks();
    }

    public void map1Tanks(){
        player.positionX = 0;
        player.positionY = 288;
        player.angle = 180;

        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        Enemy enemy4 = new Enemy();
        Enemy enemy5 = new Enemy();
        Enemy enemy6 = new Enemy();
        Enemy enemy7 = new Enemy();
        Enemy enemy8 = new Enemy();
        enemy1.positionX = 0;
        enemy1.positionY = 160;
        enemy1.angle = 180;
        enemy2.positionX = 128;
        enemy2.positionY = 128;
        enemy2.angle = 180;
        enemy3.positionX = 192;
        enemy3.positionY = 192;
        enemy3.angle = 0;
        enemy4.positionX = 352;
        enemy4.positionY = 160;
        enemy4.angle = 180;
        enemy5.positionX = 480;
        enemy5.positionY = 256;
        enemy5.angle = 0;
        enemy6.positionX = 352;
        enemy6.positionY = 352;
        enemy6.angle = 180;
        enemy7.positionX = 288;
        enemy7.positionY = 384;
        enemy7.angle = 0;
        enemy8.positionX = 192;
        enemy8.positionY = 448;
        enemy8.angle = 270;
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        enemies.add(enemy6);
        enemies.add(enemy7);
        enemies.add(enemy8);
    }

    public void map2Tanks(){
        player.positionX = 64;
        player.positionY = 352;
        player.angle = 270;

        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        Enemy enemy4 = new Enemy();
        Enemy enemy5 = new Enemy();
        Enemy enemy6 = new Enemy();
        Enemy enemy7 = new Enemy();
        Enemy enemy8 = new Enemy();
        Enemy enemy9 = new Enemy();
        enemy1.positionX = 96;
        enemy1.positionY = 0;
        enemy1.angle = 270;
        enemy2.positionX = 480;
        enemy2.positionY = 32;
        enemy2.angle = 180;
        enemy3.positionX = 288;
        enemy3.positionY = 96;
        enemy3.angle = 0;
        enemy4.positionX = 288;
        enemy4.positionY = 160;
        enemy4.angle = 180;
        enemy5.positionX = 32;
        enemy5.positionY = 192;
        enemy5.angle = 270;
        enemy6.positionX = 384;
        enemy6.positionY = 288;
        enemy6.angle = 0;
        enemy7.positionX = 320;
        enemy7.positionY = 320;
        enemy7.angle = 180;
        enemy8.positionX = 448;
        enemy8.positionY = 320;
        enemy8.angle = 0;
        enemy9.positionX = 224;
        enemy9.positionY = 448;
        enemy9.angle = 180;
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        enemies.add(enemy6);
        enemies.add(enemy7);
        enemies.add(enemy8);
        enemies.add(enemy9);
    }

    public void map3Tanks(){
        player.positionX = 0;
        player.positionY = 480;
        player.angle = 0;

        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        Enemy enemy4 = new Enemy();
        Enemy enemy5 = new Enemy();
        Enemy enemy6 = new Enemy();
        Enemy enemy7 = new Enemy();
        Enemy enemy8 = new Enemy();
        Enemy enemy9 = new Enemy();
        Enemy enemy10 = new Enemy();
        Enemy enemy11 = new Enemy();
        Enemy enemy12 = new Enemy();
        Enemy enemy13 = new Enemy();
        enemy1.positionX = 96;
        enemy1.positionY = 0;
        enemy1.angle = 270;
        enemy2.positionX = 288;
        enemy2.positionY = 0;
        enemy2.angle = 180;
        enemy3.positionX = 480;
        enemy3.positionY = 32;
        enemy3.angle = 180;
        enemy4.positionX = 160;
        enemy4.positionY = 64;
        enemy4.angle = 270;
        enemy5.positionX = 352;
        enemy5.positionY = 96;
        enemy5.angle = 0;
        enemy6.positionX = 0;
        enemy6.positionY = 128;
        enemy6.angle = 180;
        enemy7.positionX = 64;
        enemy7.positionY = 192;
        enemy7.angle = 90;
        enemy8.positionX = 352;
        enemy8.positionY = 224;
        enemy8.angle = 270;
        enemy9.positionX = 288;
        enemy9.positionY = 288;
        enemy9.angle = 180;
        enemy10.positionX = 64;
        enemy10.positionY = 320;
        enemy10.angle = 270;
        enemy11.positionX = 416;
        enemy11.positionY = 352;
        enemy11.angle = 180;
        enemy12.positionX = 96;
        enemy12.positionY = 480;
        enemy12.angle = 0;
        enemy13.positionX = 224;
        enemy13.positionY = 480;
        enemy13.angle = 0;
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        enemies.add(enemy6);
        enemies.add(enemy7);
        enemies.add(enemy8);
        enemies.add(enemy9);
        enemies.add(enemy10);
        enemies.add(enemy11);
        enemies.add(enemy12);
        enemies.add(enemy13);
    }

    /**
     * Pazua gry
     */
    @Override
    public void pauseGame() {
        timer.cancel();
    }

    /**
     * Pazua gry
     */
    @Override
    public void resumeGame() {
        timer = new Timer();
        renderWithFreq(60);
    }

    /**
     * Koniec gry
     */
    @Override
    public void endGame() {
        timer.cancel();
    }

    /**
     * Metoda odpowiedzialna za odswiezanie gry
     * @param fps ilosc klatek na sekunde
     */
    private void renderWithFreq(Integer fps){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handle(); render();
            }
        }, 1000/fps , 1000 / fps);
    }

    /**
     * Obsluga gry
     */
    private void handle(){
        physics.getBulletPhysics().handle();
        physics.getEnemyTanksPhysics().handle();
        physics.getEnemyBulletPhysics().handle();
    }

    /**
     * Metoda odpowiedzialna za renderowanie gry
     */
    private void render(){
        render.render();
        render.update();
    }

    private void nextLevel(){
        if(map.code == 0) map.code = 1;
        else if(map.code == 1) map.code = 2;
        else if(map.code == 2) map.code = 0;
        //map.layers[1].blocks[1][1].code
    }

    public Boolean isOnMap(MapObject object){
        return object != null
                && isOnMap(object.getCoordinateX(), object.getCoordinateY());
    }

    public Boolean isOnMap(Integer coordinateX, Integer coordinateY){
        return coordinateX >= 0 && coordinateX < map.width
                && coordinateY >= 0 && coordinateY < map.height;
    }

    public Boolean isEmptySpace(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return isOnMap(coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY] == null;
    }

    public Boolean isOpaqueObject(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return !isEmptySpace(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY].isOpaque();
    }

    public Boolean isDestructibleObject(MapLayer layer, Integer coordinateX, Integer coordinateY){
        return !isEmptySpace(layer, coordinateX, coordinateY)
                && layer.blocks[coordinateX][coordinateY].isDestructible();
    }

    /**
     * Zwraca sterownik gry
     * @return Steronik silnika
     */
    public EngineDriver getDriver(){
        return this.driver;
    }

    /**
     * Zwraca silnik gry
     * @return Fizyka silnika
     */
    public EnginePhysics getPhysics(){
        return this.physics;
    }

    /**
     * Zwraca obiekt renderujacy gre
     * @return Obiekt renderujacy mape
     */
    public EngineRender getRender(){
        return this.render;
    }

}
