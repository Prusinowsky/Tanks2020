package app.windows.components;

import app.Container;
import app.config.ConfigInterface;
import app.entities.MapEntity;
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

    private MapEntity map;
    private MapLoaderInterface mapLoader;

    /**
     * Konstrukor Domyslny
     * @param config
     */
    public GameMapComponent(ConfigInterface config){
        this.config = config;

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
        Graphics2D graphic = (Graphics2D)g;

        Integer gridX = map.sizeX;
        Integer gridY = map.sizeY;
        Integer width = (int)(getWidth() * 0.95);
        Integer height = (int)(getHeight() * 0.95);

        if(width < 10 || height < 10) return;

        width = height = Math.min(width,height);
        Integer sWidth = width/gridX;
        Integer sHeight = height/gridY;
        Integer offsetX = (getWidth() - gridX*sWidth)/2;
        Integer offsetY = (getHeight() - gridY*sHeight)/2;

        for(Integer j=0; j < gridX; j++)
        {
            for(Integer i=0; i < gridY; i++)
            {
                Image scaled = map.blocks[i][j].image.getScaledInstance(sWidth, sHeight, Image.SCALE_DEFAULT);
                graphic.drawImage(scaled, offsetX + sWidth*i,offsetY + sHeight*j, null);
            }
        }

    }
}
