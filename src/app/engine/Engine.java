package app.engine;

import app.entities.EnemyEntity;
import app.entities.MapEntity;
import app.entities.PlayerEntity;
import app.loaders.map.MapLoaderInterface;
import app.loaders.texture.TextureLoader;

import java.util.HashMap;

public class Engine implements EngineInterface {

//    private Time time; // Licznik czasu :)
    private Integer score;


    private PlayerEntity player;
    private EnemyEntity[] enemies;
    private MapEntity map;

    private TextureLoader textureLoader;
    private MapLoaderInterface mapLoader;


    @Override
    public void startGame() {

    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void endGame() {

    }

    @Override
    public void getGraphics() {

    }
}
