package app.engine;

import app.engine.physics.*;
import app.entities.map.objects.Portal;

/**
 * Obiekt odpowiedzialny za fizyke gry
 */
public class EnginePhysics {

    private Engine engine;
    private PlayerPhysics playerPhysics;
    private EnemiesPhysics enemiesPhysics;
    private ObstaclesPhysics obstaclesPhysics;
    private BulletsPhysics bulletsPhysics;
    private PortalPhysics portalPhysics;

    /**
     * Konstruktor domyslny
     * @param engine
     */
    public EnginePhysics(Engine engine){
        this.engine = engine;
        playerPhysics = new PlayerPhysics(engine);
        enemiesPhysics = new EnemiesPhysics(engine);
        obstaclesPhysics = new ObstaclesPhysics(engine);
        bulletsPhysics = new BulletsPhysics(engine);
        portalPhysics = new PortalPhysics(engine);
    }

    /**
     * Zwraca obiekt fiyzki gracza
     * @return Fizyka gracza
     */
    public PlayerPhysics getPlayerPhysics(){
        return playerPhysics;
    }

    /**
     * Zwraca obiekt fiyzki wrogów
     * @return Fizyka wroga
     */
    public EnemiesPhysics getEnemiesPhysics(){
        return enemiesPhysics;
    }

    /**
     * Zwraca obiekt fiyzki przeszkód
     * @return Fizyka wroga
     */
    public ObstaclesPhysics getObstaclesPhysics(){
        return obstaclesPhysics;
    }

    /**
     * Zwraca obiekt fiyzki kul
     * @return Fizyka kul
     */
    public BulletsPhysics getBulletsPhysics(){
        return bulletsPhysics;
    }

    /**
     * Zwraca obiekt fiyzki kul
     * @return Fizyka kul
     */
    public PortalPhysics getPortalPhysics(){
        return portalPhysics;
    }

}
