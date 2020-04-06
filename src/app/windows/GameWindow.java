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

        centreWindow(this);
    }

    /**
     * Metoda centrująca położenie okna
     * @param frame Zawiera przekazane okno
     */
    public static void centreWindow(GameWindow frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
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
