package app.display.windows;

import app.Container;
import app.config.ConfigInterface;
import app.display.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EndGameWindow extends AbstractWindow {

    private ConfigInterface config;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JButton bOk;
    private JLabel lScore;

    public EndGameWindow(){
        config = Container.getInstance().provideConfig();

        setSize(400,300);
        setTitle(config.getProperty("you_lost"));

        GridBagLayout gridbag = new GridBagLayout();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        addEndGameScore();
        addOkBtn();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        centreWindow();
    }

    /**
     * Metoda dodająca opis gry
     */
    private void addEndGameScore(){
        lScore = new JLabel(config.getProperty("you_lost_your_score_isp") + "420");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lScore, gbc);
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
