package app.windows.components;

import app.Container;
import app.config.ConfigInterface;
import app.entities.map.MapEntity;
import app.loaders.map.MapLoaderInterface;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Komponent zawierajacy renderujacy mapę
 */
public class GameMapComponent extends JPanel {

    private ConfigInterface config;

    private Image imageScreen;

    private MapEntity map;
    private MapLoaderInterface mapLoader;

    /**
     * Konstrukor Domyslny
     * @param config
     */
    public GameMapComponent(ConfigInterface config, Image imageScreen){
        this.config = config;
        this.imageScreen = imageScreen;

        setLayout(null);
        setSize(new Dimension(500, 500));

        mapLoader = Container.getInstance().provideMapLoader();
        map = mapLoader.getMap(Container.getInstance().provideOptions().mapName);

        setVisible(true);
    }

    /**
     * Metoda renderujaca mapę co 60 FPS
     */
    public void renderPeriodically(){
        java.util.Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 1000/30);
    }

    /**
     * Metoda odpowiadajaca za rysowanie mapy
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Integer min = (int) (Math.min(getWidth(), getHeight()) * 0.95);

        Image imageScreenScaled = imageScreen.getScaledInstance(min, min, Image.SCALE_DEFAULT);

        Integer offsetX = (getWidth() - imageScreenScaled.getWidth(null)) >> 1;
        Integer offsetY = (getHeight() - imageScreenScaled.getHeight(null)) >> 1;

        g.drawImage(imageScreenScaled, offsetX, offsetY, imageScreenScaled.getWidth(null) , imageScreenScaled.getWidth(null), null);
    }
}
