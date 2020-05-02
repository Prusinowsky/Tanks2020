package app.engine;

import app.engine.physics.BulletPhysics;
import app.engine.physics.EnemyBulletPhysics;
import app.engine.physics.EnemyTanksPhysics;
import app.engine.physics.PlayerTankPhysics;

/**
 * Obiekt odpowiedzialny za fizyke gry
 */
public class EnginePhysics {

    private Engine engine;
    private PlayerTankPhysics playerTankPhysics;
    private EnemyTanksPhysics enemyTanksPhysics;
    private BulletPhysics bulletPhysics;
    private EnemyBulletPhysics enemyBulletPhysics;

    /**
     * Konstruktor domyslny
     * @param engine
     */
    public EnginePhysics(Engine engine){
        this.engine = engine;
        playerTankPhysics = new PlayerTankPhysics(engine);
        enemyTanksPhysics = new EnemyTanksPhysics(engine);
        bulletPhysics = new BulletPhysics(engine);
        enemyBulletPhysics = new EnemyBulletPhysics(engine);
    }

    /**
     * Zwraca obiekt fiyzki gracza
     * @return Fizyka gracza
     */
    public PlayerTankPhysics getPlayerTankPhysics(){
        return playerTankPhysics;
    }

    /**
     * Zwraca obiekt fiyzki wrogów
     * @return Fizyka wroga
     */
    public EnemyTanksPhysics getEnemyTanksPhysics(){
        return enemyTanksPhysics;
    }

    /**
     * Zwraca obiekt fiyzki kul
     * @return Fizyka kul
     */
    public BulletPhysics getBulletPhysics(){
        return bulletPhysics;
    }

    /**
     * Zwraca obiekt fiyzki kul wroga
     * @return Fizyka kul wroga
     */
    public EnemyBulletPhysics getEnemyBulletPhysics() { return  enemyBulletPhysics; }

}
