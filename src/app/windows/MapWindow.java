package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klasa wyboru mapy
 */
public class MapWindow extends AbstractWindow
{
    private JButton bOkey, bCancel;
    private JComboBox cbMaps;
    //private String[] mapsList = {"Polana","Pustynia","Wulkan"};


    /**
     * Konstruktor odpowiadający za inicjalizację okna mapy
     */
    public MapWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("choose_map"));

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.BOTH;

        addChooseMapLabel(config.getProperty("choose_map"), c, null);
        addChooseMapComboBox(c, null, config);
        addCancelBtn(config.getProperty("cancel"), c, new ExitWindowAction(this));
        addOkBtn(config.getProperty("ok"), c, new OpenWindowAction(this));

        centreWindow();
    }

    /**
     * Metoda dodająca etykietę wyboru mapy
     * @param name Tytuł etykiety
     * @param constraints
     * @param action
     */
    private void addChooseMapLabel(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        JLabel label = new JLabel(name);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(label, constraints);
    };

    /**
     * Metoda dodająca pole wybóru map
     * @param constraints
     * @param action
     */
    private void addChooseMapComboBox(
            GridBagConstraints constraints,
            ActionListener action,
            Config config
    ){
        String[] mapsList = {config.getProperty("map_name_0"), config.getProperty("map_name_1"), config.getProperty("map_name_2")};
        cbMaps = new JComboBox(mapsList);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        add(cbMaps, constraints);
    };

    /**
     * Metoda dodajaca przycisk anuluj
     * @param name
     * @param constraints
     * @param action
     */
    private void addCancelBtn(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        bOkey = new JButton(name);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(bOkey, constraints);
        bOkey.addActionListener(action);
    };


    /**
     * Metoda dodajaca przycisk Ok
     * @param name
     * @param constraints
     * @param action
     */
    private void addOkBtn(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        bCancel = new JButton(name);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(bCancel, constraints);
        bCancel.addActionListener(action);
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
