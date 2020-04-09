package app.windows;

import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.components.GameMapComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Okno Gry
 */
@SuppressWarnings("serial")
public class GameWindow extends AbstractWindow
{


    /**
     * Kontruktor inicjalizujący okno gry
     */

    public GameWindow()
    {
        Config config = Config.getInstance();

        setSize(900,900);
        setTitle(config.getProperty("game_window_title"));
        setLayout(new BorderLayout());

        //add(new GameMapComponent(config));

        centreWindow();
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
