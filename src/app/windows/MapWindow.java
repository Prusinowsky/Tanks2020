package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klasa wyboru mapy
 */
public class MapWindow extends JFrame implements WindowInterface
{
    private JButton bOkey, bCancel;
    private JComboBox cbMaps;
    private String[] mapsList = {"Polana","Pustynia","Wulkan"};
    /**
     * Konstruktor odpowiadający za inicjalizację okna mapy
     */
    public MapWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("choose_map"));
        setLayout(null);

        cbMaps = new JComboBox(mapsList);
        cbMaps.setBounds(50,50,200,50);
        cbMaps.setSize(180,23);
        add(cbMaps);

        bOkey = new JButton(config.getProperty("ok"));
        bOkey.setBounds(50,120,80,20);
        add(bOkey);
        bOkey.addActionListener(new ExitWindowAction(this));

        bCancel = new JButton(config.getProperty("cancel"));
        bCancel.setBounds(150,120,80,20);
        add(bCancel);
        bCancel.addActionListener(new OpenWindowAction(this));

        centreWindow(this);
    }

    /**
     * Metoda centrująca położenie okna
     * @param frame Zawiera przekazane okno
     */
    public static void centreWindow(MapWindow frame) {
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
