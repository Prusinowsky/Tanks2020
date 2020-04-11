package app.windows.components;

import app.actions.ChangeStateAction;
import app.config.ConfigInterface;
import app.windows.GameWindow;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Komponent odpowiadający za renderowanie HUD-a
 */
public class GameHudComponent extends JPanel {

    private GameWindow gameWindow;
    private JLabel lTime, lHeart[], lLogo;
    private JButton bPause, bExit;

    /**
     * Konstrukotr dymyślny
     * @param config
     */
    public GameHudComponent(ConfigInterface config, GameWindow gameWindow){
        this.gameWindow = gameWindow;

        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setSize(new Dimension(200, 500));
        setVisible(true);
    }

    /**
     * Metoda renderująca HUD'a
     */

    public void render()
    {
        removeAll();

        lLogo = new JLabel("TANK 2020");
        lLogo.setBounds( 25,20,50,50);
        add(lLogo);

        lTime = new JLabel("0:01:34");           //czas do końca gry będzie ustalany przez silnik
        lTime.setBounds( 25,80, 80,20);
        add(lTime);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lHeart = new JLabel[numberOfLifes];
        ImageIcon picHeart = new ImageIcon("assets/textures/hud/life.png");

        for (Integer i=0; i<numberOfLifes; i++)
        {
            lHeart[i] = new JLabel(picHeart);
            lHeart[i].setBounds( 20 + 20*i,120,20,20);
            add(lHeart[i]);
        }

        Integer y = getHeight();

        bPause = new JButton("Pause");
        bPause.setBounds( (int)(getWidth()*0.1), y - 120, (int)(getWidth()*0.8),40);
        add(bPause);

        bExit = new JButton("Exit");
        bExit.setBounds( (int)(getWidth()*0.1),y - 60,(int)(getWidth()*0.8),40);
        bExit.addActionListener(new ChangeStateAction(gameWindow, "menu"));
        add(bExit);

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

