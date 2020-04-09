package app.windows;

import app.actions.ExitWindowAction;
import app.config.Config;
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
    private JLabel lAbout;
    private JButton bOkey;

    /**
     * Konstruktor inicjalizujący okno pomocy
     */
    public HelpWindow()
    {
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("about"));

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.BOTH;

        addGameDescription(config.getProperty("game_description"),c, null);
        addOkBtn(config.getProperty("ok"), c, new ExitWindowAction(this));

        centreWindow();
    }

    /**
     * Metoda dodająca opis gry
     * @param name Opis gry
     * @param constraints
     * @param action
     */
    private void addGameDescription(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        lAbout = new JLabel(name);
        //lAbout.setBounds(50,50,200,20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(lAbout, constraints);
    }

    /**
     * Metoda dodająca przycisk ok
     * @param name Nazwa przycisku
     * @param constraints
     * @param action
     */
    private void addOkBtn(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        bOkey = new JButton(name);
        //bOkey.setBounds(110,80,80,20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        add(bOkey, constraints);
        bOkey.addActionListener(action);
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
