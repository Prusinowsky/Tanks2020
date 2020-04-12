package app.windows;
import app.Container;
import app.actions.ExitWindowAction;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Okno zawierający najlepsze wyniki
 */
@SuppressWarnings("serial")
public class ScoreWindow extends AbstractWindow
{
    private ConfigInterface config;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JLabel lList;
    private JButton bOkey;

    /**
     * Kontruktor odpowiadajacy za inicjalizację okna z najlepszymi wynikami
     */
    public ScoreWindow()
    {
        config = Container.getInstance().provideConfig();

        setSize(400,300);
        setTitle(config.getProperty("best_scores"));

        GridBagLayout gridbag = new GridBagLayout();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        addScoreList();
        addOkBtn();

        centreWindow();
    }

    /**
     * Metoda dodająca opis gry
     */
    private void addScoreList(){
        lList = new JLabel("Tu będzie kiedyś lista wyników");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lList, gbc);
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
