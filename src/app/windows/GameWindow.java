package app.windows;

import app.config.Config;
import app.loaders.texture.TextureLoader;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Okno Gry
 */
public class GameWindow extends AbstractWindow
{
    private ImageIcon icon;
    private Boolean resize;
    private JLabel[][] pic;

    /**
     * Kontruktor inicjalizujący okno gry
     */
    public GameWindow()
    {
        resize = false;
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                resize = true;
            }
        }, 0, 500);

        Config config = Config.getInstance();

        setSize(900,900);
        setTitle(config.getProperty("game_window_title"));

        setLayout(null);

        TextureLoader textureLoader = new TextureLoader();
        textureLoader.loadAll();

        icon = new ImageIcon(textureLoader.get("Magma").image);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                if(resize) {
                    resize = false;
                    setResizable(false);
                    renderMap();
                    setResizable(true);
                }
            }
        });

        this.setResizable(false);

        centreWindow();
    }

    /**
     * Funkcja renderująca mapę
     */
    private void renderMap()
    {
        Integer gridX = 16;
        Integer gridY = 16;
        Integer width = (int)(getWidth()*0.9);
        Integer height = (int)((getHeight() - 39)*0.9);
        width = height = Math.min(width,height);
        Integer sWidth = width/gridX;
        Integer sHeight = height/gridY;
        Integer offsetX = (getWidth() - gridX*sWidth)/2;
        Integer offsetY = (getHeight() - gridY*sHeight)/2;
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
                pic[i][j].setBounds(offsetX + sWidth*i,offsetY + sHeight*j, sWidth, sHeight);
                add(pic[i][j]);
            }
        }
        getContentPane().repaint();
    }


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
