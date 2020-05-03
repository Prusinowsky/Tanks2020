package app.engine.physics;

import app.engine.Engine;
import app.entities.map.objects.Bullet;
import app.entities.map.objects.EnemyBullet;

/**
 * Obiekt odpowiedzialny za fizykę kul przeciwnika
 */
public class EnemyBulletPhysics {
    private Engine engine;

    public EnemyBulletPhysics(Engine engine){
        this.engine = engine;
    }

    /**
     * Metoda odpowiedzialna za obsługę wszystkich pocisków
     */
    public void handle(){
        for(Integer i=0; i < engine.enemyBullets.size(); i++){
            handleSingleBullet(engine.enemyBullets.get(i));
        }
    }

    /**
     * Metoda odpowiedzialna za obsługę pojedynczego pocisku
     * @param enemyBullet
     */
    public void handleSingleBullet(EnemyBullet enemyBullet){
        moveSingle(enemyBullet);
        destroyPlayerTank(enemyBullet);
        checkCollision(enemyBullet);
    }

    /**
     * Metoda odpowiedzialna za poruszanie pocisku
     * @param enemyBullet
     */
    public void moveSingle(EnemyBullet enemyBullet){
        if(enemyBullet.angle == 0){
            enemyBullet.positionY -= 4;
        }
        else if(enemyBullet.angle == 90){
            enemyBullet.positionX += 4;
        }
        else if(enemyBullet.angle == 180){
            enemyBullet.positionY += 4;
        }
        else if(enemyBullet.angle == 270){
            enemyBullet.positionX -= 4;
        }
    }

    /**
     * Metoda odpowiedzialna za sprawdzenie kolizji na drodze pocisku
     * @param enemyBullet
     */
    public void checkCollision(EnemyBullet enemyBullet){
        if(!engine.isOnMap(enemyBullet)){
            engine.enemyBullets.remove(enemyBullet);
            return;
        }
        if(engine.isOpaqueObject(engine.map.layers[1], enemyBullet.getCoordinateX(), enemyBullet.getCoordinateY())){
            engine.enemyBullets.remove(enemyBullet);
        }
    }

    /**
     * Metoda odpowiedzialna za niszczenie czołgu gracza
     * @param enemyBullet
     */
    public void destroyPlayerTank(EnemyBullet enemyBullet){
        if(!engine.isOnMap(enemyBullet)){
            engine.bullets.remove(enemyBullet);
        }
        if(engine.player.isOnTheSameCoordinate(enemyBullet)){
            deathTankBehaviour(enemyBullet);
        }
    }

    /**
     * Metoda odpowiedzialna za zachowanie po zniszczeniu czołgu gracza
     * @param enemyBullet
     */
    public void deathTankBehaviour(EnemyBullet enemyBullet){
        engine.enemyBullets.remove(enemyBullet);
        engine.lifes -= 1;
        engine.enemyBullets.clear();
        engine.reloadMap();
        if(engine.lifes == 0) engine.endGame(); //tu będzie wywołanie okna końca gry
    }
}
