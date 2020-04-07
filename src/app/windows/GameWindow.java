package app.windows;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Okno Gry
 */
public class GameWindow extends AbstractWindow
{
    private JLabel[][] pic;

    /**
     * Kontruktor inicjalizujący okno gry
     */
    public GameWindow()
    {
        Config config = Config.getInstance();

        setSize(900,900);
        setTitle(config.getProperty("game_window_title"));

        GridLayout grid = new GridLayout(16,16);
        setLayout(grid);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                renderMap();
            }
        });

        centreWindow();
    }

    /**
     * Metoda renderująca mapę
     */
    private void renderMap()
    {
        Integer gridX = 16;
        Integer gridY = 16;
        Integer width = getWidth();
        Integer height = getHeight() - 39;
        width = height = Math.min(width,height);
        Integer sWidth = width/gridX;
        Integer sHeight = height/gridY;
        ImageIcon icon = new ImageIcon("assets/textures/maps/plain/grass.png");
        Image imageScaled = icon
                .getImage()
                .getScaledInstance(sWidth, sHeight, Image.SCALE_DEFAULT);
        ImageIcon iconScaled = new ImageIcon(imageScaled);
        pic = null;
        pic = new JLabel[gridX][gridY];

        getContentPane().removeAll();

        for(Integer i=0; i<gridX; i++)
        {
            for(Integer j=0; j<gridY; j++)
            {
                pic[i][j] = new JLabel(iconScaled);
                pic[i][j].setBounds(sWidth*i,sHeight*j, sWidth, sHeight);
                add(pic[i][j]);
            }
        }
        getContentPane().repaint();
    }
    /*(new ImageIcon("assets/textures/maps/plain/grass.png").getImage().getScaledInstance(getWidth()/gridX, getHeight()/gridY, Image.SCALE_DEFAULT))*/
    /**
     * Metoda implementująca otwarcie okna
     */
    public void open()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Metoda implementująca zamknięcie okna
     */
    public void close()
    {
        dispose();
    }

}
