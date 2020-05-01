package app.engine;

import app.Container;
import app.engine.interfaces.EngineInterface;
import app.entities.map.MapLayer;
import app.entities.map.MapObject;
import app.entities.map.objects.Bullet;
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

        loadEnemies();

        timer = new Timer();
        renderWithFreq(60);
    }

    public void loadEnemies(){
        enemies.clear();
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
    }

    /**
     * Metoda odpowiedzialna za renderowanie gry
     */
    private void render(){
        render.render();
        render.update();
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
