package app.windows;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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

        setSize(800,800);
        setTitle(config.getProperty("game_window_title"));
        setLayout(null);

        renderMap();

        centreWindow();
    }

    /**
     * Metoda renderująca mapę
     */
    private void renderMap()
    {
        Integer gridX = 16;
        Integer gridY = 16;
        pic = new JLabel[gridX][gridY];
        for(int i=0; i<gridX; i++)
        {
            for(int j=0; j<gridY; j++)
            {
                pic[i][j] = new JLabel(new ImageIcon("assets/textures/maps/plain/grass.png"));
                pic[i][j].setBounds(30 + 32*i,30 + 32*j,32,32);
                add(pic[i][j]);
            }
        }
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
