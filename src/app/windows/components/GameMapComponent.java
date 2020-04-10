package app.windows.components;

import app.config.interfaces.ConfigInterface;
import app.entities.MapEntity;
import app.loaders.map.MapLoader;
import app.loaders.texture.TextureLoader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Komponent zawierajacy renderujacy mapę
 */
public class GameMapComponent extends JPanel {

    private ConfigInterface config;

    private MapEntity map;
    private MapLoader mapLoader;

    private JLabel[][] pic;

    /**
     * Konstrukor Domyslny
     * @param config
     */
    public GameMapComponent(ConfigInterface config){
        this.config = config;
        setLayout(null);

        setSize(new Dimension(500, 500));

        TextureLoader textureLoader = new TextureLoader(config);
        textureLoader.load();

        mapLoader = new MapLoader(textureLoader);
        mapLoader.load();

        map = mapLoader.getMap("Pustynia");

        setVisible(true);
    }

    /**
     * Funkcja renderująca mapę
     */
    public void render()
    {
        removeAll();

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

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
