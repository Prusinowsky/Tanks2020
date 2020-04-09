package app.windows.components;

import app.config.Config;
import app.config.interfaces.ConfigInterface;
import app.entities.MapEntity;
import app.loaders.map.MapLoader;
import app.loaders.texture.TextureLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Komponent zawierajacy renderujacy mapę
 */
public class GameMapComponent extends JComponent {

    private ConfigInterface config;
    private Integer width, height;

    private MapEntity map;
    private MapLoader mapLoader;

    private JLabel[][] pic;

    public GameMapComponent(ConfigInterface config, Integer width, Integer height){
        setLayout(null);
        this.width = width;
        this.height = height;

        setSize(width, height);

        TextureLoader textureLoader = new TextureLoader(config);
        textureLoader.load();

        mapLoader = new MapLoader(textureLoader);
        mapLoader.load();

        map = mapLoader.getMap("Dolina");

        render();
    }

    /**
     * Funkcja renderująca mapę
     */
    public void render()
    {

        Integer gridX = map.sizeX;
        Integer gridY = map.sizeY;
        Integer width = (int)(getWidth()*0.95);
        Integer height = (int)(getHeight() *0.95);

        if(width < 10 || height < 10) return;

        width = height = Math.min(width,height);
        Integer sWidth = width/gridX;
        Integer sHeight = height/gridY;
        Integer offsetX = (getWidth() - gridX*sWidth)/2;
        Integer offsetY = (getHeight() - gridY*sHeight)/2;

        pic = new JLabel[gridX][gridY];


        for(Integer j=0; j<gridX; j++)
        {
            for(Integer i=0; i<gridY; i++)
            {
                Image image = map.blocks[i][j].image.getScaledInstance(sWidth, sHeight, Image.SCALE_DEFAULT);
                pic[i][j] = new JLabel(new ImageIcon(image));
                pic[i][j].setBounds(offsetX + sWidth*i,offsetY + sHeight*j, sWidth, sHeight);
                add(pic[i][j]);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
