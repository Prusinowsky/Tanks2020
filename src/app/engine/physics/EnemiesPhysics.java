package app.engine.physics;

import app.engine.Engine;
import app.entities.map.tanks.Enemy;

import java.util.ArrayList;

/**
 * Obiekt odpowiedzialny za fizykę wrogów
 */
public class EnemiesPhysics {

    private Engine engine;
    private ArrayList<EnemyPhysics> enemiesPhysics;


    public EnemiesPhysics(Engine engine){
        this.engine = engine;
        init();
    }

    private void init(){
        enemiesPhysics = new ArrayList<EnemyPhysics>();
        engine.enemies.forEach((enemy -> {
            enemiesPhysics.add(new EnemyPhysics(engine, enemy));
        }));
    }

    public void reinit(){
        init();
    }

    /**
     * Metoda odpowiadająca za obsługę wszystkich czołgów wroga
     */
    public void handle(){
        for(Integer i = 0; i < enemiesPhysics.size(); i++){
            EnemyPhysics enemyPhysics = enemiesPhysics.get(i);
            enemyPhysics.handle();
        }
    }

    public void remove(EnemyPhysics enemyPhysics){
        enemiesPhysics.remove(enemyPhysics);
    }

    public Enemy[] getEnemies(){
        return enemiesPhysics.stream().map(EnemyPhysics::getEnemy).toArray(Enemy[]::new);
    }

}
