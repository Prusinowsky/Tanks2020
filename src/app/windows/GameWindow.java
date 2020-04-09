package app.windows;

import app.config.Config;
import app.entities.MapEntity;
import app.loaders.map.MapLoader;
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
@SuppressWarnings("serial")
public class GameWindow extends AbstractWindow
{

    private MapLoader mapLoader;
    private MapEntity map;
    private Boolean resize;
    private JLabel[][] pic;

    /**
     * Kontruktor inicjalizujący okno gry
     */

    public GameWindow()
    {
        Config config = Config.getInstance();

        setSize(900,900);
        setTitle(config.getProperty("game_window_title"));
        setLayout(null);

        setRefreshTime();

        //System.out.println("Ladowanie tekstur");
        TextureLoader textureLoader = new TextureLoader();
        textureLoader.loadAll();

        //System.out.println("Ladowanie Map");
        mapLoader = new MapLoader();
        mapLoader.load();

        map = mapLoader.getMap("Wulkan");

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

    private void setRefreshTime(){
        resize = false;
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                resize = true;
            }
        }, 0, 500);
    }

    /**
     * Funkcja renderująca mapę
     */
    private void renderMap()
    {
        Integer gridX = map.sizeX;
        Integer gridY = map.sizeY;
        Integer width = (int)(getWidth()*0.9);
        Integer height = (int)((getHeight() - 39)*0.9);
        width = height = Math.min(width,height);
        Integer sWidth = width/gridX;
        Integer sHeight = height/gridY;
        Integer offsetX = (getWidth() - gridX*sWidth)/2;
        Integer offsetY = (getHeight() - gridY*sHeight)/2;

        pic = new JLabel[gridX][gridY];
        getContentPane().removeAll();

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
