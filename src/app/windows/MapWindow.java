package app.windows;

import app.Container;
import app.actions.ChangeMapAction;
import app.actions.ChangeStateAction;
import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klasa wyboru mapy
 */
@SuppressWarnings("serial")
public class MapWindow extends AbstractWindow
{
    private ConfigInterface config;
    private GameWindow gameWindow;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JButton bOkey, bCancel;
    private JComboBox <String> cbMaps;

    /**
     * Konstruktor odpowiadający za inicjalizację okna mapy
     */
    public MapWindow(GameWindow gameWindow)
    {
        this.gameWindow = gameWindow;
        this.config = Container.getInstance().provideConfig();

        setSize(400,300);
        setTitle(config.getProperty("choose_map"));

        GridBagLayout gridbag = new GridBagLayout();

        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        addChooseMapLabel();
        addChooseMapComboBox();
        addCancelBtn();
        addOkBtn();

        centreWindow();
    }

    /**
     * Metoda dodająca etykietę wyboru mapy
     */
    private void addChooseMapLabel(){
        JLabel label = new JLabel(config.getProperty("choose_map"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(label, gbc);
    };

    /**
     * Metoda dodająca pole wybóru map
     */
    private void addChooseMapComboBox(){
        Integer number = Integer.parseInt(config.getProperty("map_numbers"));
        String[] mapList = new String[number];
        for(Integer i = 0; i < number; i++){
            mapList[i] = config.getProperty("map_name_"+i);
        }
        cbMaps = new JComboBox<String>(mapList);
        cbMaps.addActionListener(new ChangeMapAction());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(cbMaps, gbc);
    };

    /**
     * Metoda dodajaca przycisk anuluj
     */
    private void addCancelBtn(){
        bOkey = new JButton(config.getProperty("cancel"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(bOkey, gbc);
        bOkey.addActionListener(new ExitWindowAction(this));
    };


    /**
     * Metoda dodajaca przycisk Ok
     */
    private void addOkBtn(){
        bCancel = new JButton(config.getProperty("ok"));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(bCancel, gbc);
        bCancel.addActionListener(new ExitWindowAction(this));
        bCancel.addActionListener(new ChangeStateAction(gameWindow, "running"));
    };

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
