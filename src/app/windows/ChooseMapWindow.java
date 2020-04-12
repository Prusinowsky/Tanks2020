package app.windows;

import app.Container;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Klasa wyboru mapy
 */
@SuppressWarnings("serial")
public class ChooseMapWindow extends AbstractWindow
{
    private ConfigInterface config;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JComboBox <String> cbMaps;
    private JButton bCancel, bOk;

    /**
     * Konstruktor odpowiadający za inicjalizację okna mapy
     */
    public ChooseMapWindow()
    {
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

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

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
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(cbMaps, gbc);
    };

    /**
     * Metoda dodajaca przycisk anuluj
     */
    private void addCancelBtn(){
        bOk = new JButton(config.getProperty("cancel"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(bOk, gbc);
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
    };

    public void addChooseMapActionListener(ActionListener action){
        cbMaps.addActionListener(action);
    }

    public void addCancelActionListener(ActionListener action){
        bCancel.addActionListener(action);
    }

    public void addOkActionListener(ActionListener action){
        bOk.addActionListener(action);
    }

}
