package app.windows;

import app.actions.ExitWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;

/**
 * Okno końca gry
 */
public class EndGameWindow extends JFrame implements WindowInterface
{
    private JLabel lInfo;
    private JButton bOkey;

    /**
     * Kontruktor inicjalizujący okno końca gry
     */
    public EndGameWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("you_lost"));
        setLayout(null);

        lInfo = new JLabel(config.getProperty("you_lost_your_score_is"));
        lInfo.setBounds(50,50,200,20);
        add(lInfo);

        bOkey = new JButton(config.getProperty("ok"));
        bOkey.setBounds(110,80,80,20);
        add(bOkey);
        bOkey.addActionListener(new ExitWindowAction(this));
    }

    /**
     * Metoda implementująca otwarcie okna
     */
    public void open()
    {
        //EndGameFrame frame = new EndGameFrame();
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
