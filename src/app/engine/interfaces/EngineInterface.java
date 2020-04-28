package app.engine.interfaces;

import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import java.awt.*;

public interface EngineInterface {
    public void startGame();
    public void pauseGame();
    public void endGame();

    public void moveUp();
    public void moveDown();
    public void moveRight();
    public void moveLeft();
    public void shoot();

    public void setGameScreenComponent(GameScreenComponent gameScreenComponent);
    public void setGameHudComponent(GameHudComponent gameHudComponent);

}
