package app.engine.utils;

import app.engine.Engine;
import app.entities.map.tanks.Enemy;

public class Tracker {

    private Engine engine;

    public void Tracker(Engine engine){
        this.engine = engine;
    }

    /**
     * Metoda odpowiedzialna za śledzenie gracza przez wroga
     * @param enemy
     */
    public void trackPlayer(Enemy enemy){
        if(enemy.getCoordinateX() == engine.player.getCoordinateX()){
            if(enemy.getCoordinateY() > engine.player.getCoordinateY()){
                if(checkObstaclesBetweenTanksX(engine.player.getCoordinateY(), enemy.getCoordinateY(), enemy.getCoordinateX())){
                    enemy.angle = 0;
                    //singleShoot(enemy);
                }
            }
            else {
                if(checkObstaclesBetweenTanksX(enemy.getCoordinateY(), engine.player.getCoordinateY(), enemy.getCoordinateX())){
                    enemy.angle = 180;
                    //singleShoot(enemy);
                }
            }
        }
        if(enemy.getCoordinateY() == engine.player.getCoordinateY()){
            if(enemy.getCoordinateX() > engine.player.getCoordinateX()){
                if(checkObstaclesBetweenTanksY(engine.player.getCoordinateX(), enemy.getCoordinateX(), enemy.getCoordinateY())){
                    enemy.angle = 270;
                    //singleShoot(enemy);
                }
            }
            else {
                if(checkObstaclesBetweenTanksY(enemy.getCoordinateX(), engine.player.getCoordinateX(), enemy.getCoordinateY())){
                    enemy.angle = 90;
                    //singleShoot(enemy);
                }
            }
        }
    }

    /**
     * Metoda odpowiedzialna za wyszukanie przeszkód między graczem, a wrogiem dla tej samej osi Y, w celu uniknięcia strzelania przez ścianę
     * @param from współrzędna X gracza/wroga
     * @param to współrzędna X wroga/gracza
     * @param constantY wspólna współrzędna Y
     * @return Boolean
     */
    public Boolean checkObstaclesBetweenTanksY(Integer from, Integer to, Integer constantY){
        Integer checker=0;
        for(Integer i=from; i<to; i+=1){
            if(!MapHelper.isEmptySpace(engine.map.layers[1],i,constantY)) checker+=1;
        }
        if(checker != 0) return false;
        else return true;
    }

    /**
     * Metoda odpowiedzialna za wyszukanie przeszkód między graczem, a wrogiem dla tej samej osi X, w celu uniknięcia strzelania przez ścianę
     * @param from współrzędna Y gracza/wroga
     * @param to współrzędna Y wroga/gracza
     * @param constantX wspólna wspólrzędna X
     * @return Boolean
     */
    public Boolean checkObstaclesBetweenTanksX(Integer from, Integer to, Integer constantX){
        Integer checker=0;
        for(Integer i=from; i<to; i+=1){
            if(!MapHelper.isEmptySpace(engine.map.layers[1],constantX,i)) checker+=1;
        }
        if(checker != 0) return false;
        else return true;
    }
}
