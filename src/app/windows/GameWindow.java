package app.windows;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Okno Gry
 */
public class GameWindow extends JFrame implements WindowInterface
{
    /**
     * Kontruktor inicjalizujący okno gry
     */
    public GameWindow()
    {
        Config config = Config.getInstance();

        setSize(800,800);
        setTitle(config.getProperty("game_window_title"));
        setLayout(null);
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
