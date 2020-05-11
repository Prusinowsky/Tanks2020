package app.engine;

import app.Container;
import app.engine.interfaces.EngineInterface;
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

    public Integer level = 0;

    public EngineDriver driver;
    public EnginePhysics physics;
    public EngineRender render;

    public Timer timer;

    public Integer score = 0;
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
        playerName = !Container.getInstance().provideOptions().nickname.isEmpty() ? Container.getInstance().provideOptions().nickname : "Player Tank";

        reloadMap();

        timer = new Timer();
        renderWithFreq(60);
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
        physics.getPlayerPhysics().handle();
        physics.getEnemiesPhysics().handle();
        physics.getObstaclesPhysics().handle();
        physics.getBulletsPhysics().handle();
        physics.getPortalPhysics().handle();
    }

    /**
     * Metoda odpowiedzialna za renderowanie gry
     */
    private void render(){
        render.render();
        render.update();
    }

    /**
     * ładowanie pozycji gracza z pliku mapy
     */
    private void loadPlayerFromMap(){
        if(map.layers[2].blocks == null) return;
        for(Integer i = 0; i < map.layers[2].width; i++)
            for(Integer j = 0; j < map.layers[2].height; j++) {
                if(map.layers[2].blocks[j][i] instanceof Player) {
                    this.player = (Player) map.layers[2].blocks[j][i];
                    this.player.positionX = j*32;
                    this.player.positionY = i*32;
                    map.layers[2].blocks[j][i] = null;
                    return;
                }
            }
    }

    /**
     * ładowanie pozycji wrogów z pliku mapy
     */
    private void loadEnemyFromMap(){
        if(map.layers[2].blocks == null) return;
        for(Integer i = 0; i < map.layers[2].width; i++)
            for(Integer j = 0; j < map.layers[2].height; j++) {
                if(map.layers[2].blocks[j][i] instanceof Enemy) {
                    Enemy enemy = (Enemy)map.layers[2].blocks[j][i];
                    enemy.positionX = j*32;
                    enemy.positionY = i*32;
                    enemies.add(enemy);
                    map.layers[2].blocks[j][i] = null;
                }
            }
    }

    /**
     * Ladowanie kolejnego poziomu gry
     */
    public void nextLevel(){
        if(++level >= 3) level = 0; // koniec gry
        Container.getInstance().provideOptions().mapName = Container.getInstance().provideConfig().getProperty("map_name_" + level);
        reloadMap();
    }

    /**
     * Przeładowanie mapy
     */
    public void reloadMap(){
        mapLoader.load();
        map = mapLoader.getMap(Container.getInstance().provideOptions().mapName);

        clearEngine();

        loadPlayerFromMap();

        loadEnemyFromMap();
        getPhysics().getEnemiesPhysics().reinit();

        getPhysics().getObstaclesPhysics().reinit();

        getPhysics().getPortalPhysics().reinit();

        clearEngine();

        purgeMap();
    }

    public void reloadByDeath(){
        lifes -= 1;
        getRender().update();
        reloadMap();
    }

    /**
     * Usuwanie z mapy poziomu 3ciego odpowiadajacego za ładowanie pozycji graczy
     */
    private void purgeMap(){
        if(map.layers[2] == null) return;
        map.layers[2] = null;
        map.numberOfLayers -= 1;
    }

    public void clearEngine(){
        this.bullets.clear();
        this.enemies.clear();
    }


    public MapEntity getMap(){
        return getPhysics().getObstaclesPhysics().getMap();
    }

    public Player getPlayer(){
        return getPhysics().getPlayerPhysics().getPlayer();
    }

    public Enemy[] getEnemies(){
        return getPhysics().getEnemiesPhysics().getEnemies();
    }

    public Bullet[] getBullets(){
        return getPhysics().getBulletsPhysics().getBullets();
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
