package app.engine;

import app.engine.interfaces.EngineInterface;
import app.entities.map.objects.Bullet;
import app.entities.map.tanks.Enemy;
import app.entities.map.MapEntity;
import app.entities.map.tanks.Player;
import app.loaders.map.MapLoaderInterface;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Silnik gry
 */
public class Engine implements EngineInterface {

    public EngineDriver driver;
    public EnginePhysics physics;
    public EngineRender render;

    protected Timer timer;

    protected Integer score;
    protected String playerName;

    protected Player player;
    protected MapEntity map;
    protected ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private MapLoaderInterface mapLoader;

    /**
     * Konstrukor dymyslny
     */
    public Engine(){
        mapLoader = app.Container.getInstance().provideMapLoader();
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
        map = mapLoader.getMap(app.Container.getInstance().provideOptions().mapName);

        player = new Player();
        player.positionX = 0;
        player.positionY = 0;
        player.angle = 0;

        loadEnemies();

        timer = new Timer();
        renderWithFreq(60);
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

    /**
     * Pazua gry
     */
    @Override
    public void pauseGame() {

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
                render();
            }
        }, 1000/fps , 1000 / fps);
    }

    /**
     * Metoda odpowiedzialna za renderowanie gry
     * (tu faktycznie obsluga + renderowanie)
     */
    private void render(){
        physics.handleBulletsBehaviour();
        physics.handleEnemyTanksBehaviour();
        render.render();
        render.update();
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
