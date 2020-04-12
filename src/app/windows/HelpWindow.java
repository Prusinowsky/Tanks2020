package app.windows;

import app.Container;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Okno pomocy
 */
@SuppressWarnings("serial")
public class HelpWindow extends AbstractWindow
{

    private ConfigInterface config;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JLabel lAbout;
    private JButton bOk;

    /**
     * Konstruktor inicjalizujący okno pomocy
     */
    public HelpWindow()
    {
        config = Container.getInstance().provideConfig();

        setSize(400,300);
        setTitle(config.getProperty("about"));

        GridBagLayout gridbag = new GridBagLayout();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        addGameDescription();
        addOkBtn();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        centreWindow();
    }

    /**
     * Metoda dodająca opis gry
     */
    private void addGameDescription(){
        lAbout = new JLabel(config.getProperty("game_description"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lAbout, gbc);
    }

    /**
     * Metoda dodająca przycisk ok
     */
    private void addOkBtn(){
        bOk = new JButton(config.getProperty("ok"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(bOk, gbc);
    }

    public void addOkActionListener(ActionListener action){
        bOk.addActionListener(action);
    }

}
