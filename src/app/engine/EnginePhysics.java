package app.engine;

import app.engine.physics.BulletBehaviour;
import app.engine.physics.EnemyTanksBehaviour;

/**
 * Obiekt odpowiedzialny za fizyke gry
 */
public class EnginePhysics {

    private Engine engine;
    private EnemyTanksBehaviour enemyTanksBehaviour;
    private BulletBehaviour bulletBehaviour;

    public EnginePhysics(Engine engine){
        this.engine = engine;
        enemyTanksBehaviour = new EnemyTanksBehaviour(engine);
        bulletBehaviour = new BulletBehaviour(engine);
    }

    public void handleBulletsBehaviour(){
        bulletBehaviour.handleBullets();
    }

    public void handleEnemyTanksBehaviour(){
        enemyTanksBehaviour.handleTanks();
    }

}
