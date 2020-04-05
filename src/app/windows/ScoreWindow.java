package app.windows;
import app.actions.ExitWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Okno zawierający najlepsze wyniki
 */
public class ScoreWindow extends JFrame implements WindowInterface
{
    private JLabel lList;
    private JButton bOkey;

    /**
     * Kontruktor odpowiadajacy za inicjalizację okna z najlepszymi wynikami
     */
    public ScoreWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("best_scores"));
        setLayout(null);

        lList = new JLabel("Tu będzie kiedyś lista wyników");
        lList.setBounds(50,50,200,20);
        add(lList);

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
