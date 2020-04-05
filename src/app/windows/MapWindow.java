package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;

/**
 * Klasa wyboru mapy
 */
public class MapWindow extends JFrame implements WindowInterface
{
    private JLabel lSelectMap;
    private JButton bOkey, bCancel;

    /**
     * Konstruktor odpowiadający za inicjalizację okna mapy
     */
    public MapWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("choose_map"));
        setLayout(null);

        lSelectMap = new JLabel(config.getProperty("map_select"));
        lSelectMap.setBounds(50,50,200,50);
        add(lSelectMap);

        bOkey = new JButton(config.getProperty("ok"));
        bOkey.setBounds(50,120,80,20);
        add(bOkey);
        bOkey.addActionListener(new ExitWindowAction(this));

        bCancel = new JButton(config.getProperty("cancel"));
        bCancel.setBounds(150,120,80,20);
        add(bCancel);
        bCancel.addActionListener(new OpenWindowAction(this));
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
