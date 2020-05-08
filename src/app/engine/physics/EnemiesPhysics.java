package app.engine.physics;

import app.engine.Engine;
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
        ArrayList<EnemyPhysics> toDelete = new ArrayList<EnemyPhysics>();
        enemiesPhysics.forEach((enemy) -> {
            if(enemy.canBeDelete()) toDelete.add(enemy);
            enemy.handle();
        });
        enemiesPhysics.removeAll(toDelete);
    }

}
