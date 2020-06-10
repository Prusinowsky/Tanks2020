package app.display.windows.Ranking;
import app.Container;
import app.config.ConfigInterface;
import app.display.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Okno zawierający najlepsze wyniki
 */
@SuppressWarnings("serial")
public class ScoreWindow extends AbstractWindow
{
    private ConfigInterface config;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JLabel[] lList;
    private JLabel lTitle;
    private JButton bOk;

    /**
     * Kontruktor odpowiadajacy za inicjalizację okna z najlepszymi wynikami
     */
    public ScoreWindow(){
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

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        centreWindow();
    }

    /**
     * Metoda dodająca opis gry
     */
    private void addScoreList(){
        //Ranking.loadRanking();
        lTitle = new JLabel("Ranking");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lTitle, gbc);
        /*for(int i = 0; i < 5; i++){
            lList[i] = new JLabel(((i+1) +". " + Ranking.getScore(i)));
            this.add(lList[i]);
        }*/
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
