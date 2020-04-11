package app.windows;

import app.Container;
import app.actions.ExitWindowAction;
import app.config.Config;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;
import app.windows.interfaces.WindowInterface;

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
    private JButton bOkey;

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
        bOkey = new JButton(config.getProperty("ok"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(bOkey, gbc);
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
