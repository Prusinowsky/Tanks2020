package app.windows.components;

import app.config.ConfigInterface;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Komponent odpowiadający za renderowanie HUD-a
 */
public class GameHudComponent extends JPanel {

    private JLabel lTime, lHeart[], lLogo;
    private JButton bPause, bExit;

    /**
     * Konstrukotr dymyślny
     * @param config
     */
    public GameHudComponent(ConfigInterface config){
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setSize(new Dimension(200, 500));
        setVisible(true);

        init();
        render();
    }

    /**
     * Inicjalizacja elementów
     */
    public void init(){
        lLogo = new JLabel("TANK 2020");
        add(lLogo);

        lTime = new JLabel("0:01:34");
        add(lTime);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lHeart = new JLabel[numberOfLifes];
        for (Integer i=0; i<numberOfLifes; i++)
        {
            ImageIcon picHeart = new ImageIcon("assets/textures/hud/life.png");
            lHeart[i] = new JLabel(picHeart);
            add(lHeart[i]);
        }

        bPause = new JButton("Pauza");
        add(bPause);

        bExit = new JButton("Powrót");
        add(bExit);
    }

    /**
     * Metoda renderująca HUD'a
     */

    public void render()
    {

        lLogo.setBounds( 25,20,50,50);
        lTime.setBounds( 25,80, 80,20);

        Integer numberOfLifes = 3; //będzie pobierana z opcji

        for (Integer i=0; i<numberOfLifes; i++)
        {
            lHeart[i].setBounds( 20 + 20*i,120,20,20);
        }

        Integer y = getHeight();
        bPause.setBounds( (int)(getWidth()*0.1), y - 120, (int)(getWidth()*0.8),40);
        bExit.setBounds( (int)(getWidth()*0.1),y - 60,(int)(getWidth()*0.8),40);

        revalidate();
        repaint();
    }

    public void addPauseActionListener(ActionListener action){
        bPause.addActionListener(action);
    }

    public void addExitActionListener(ActionListener action){
        bExit.addActionListener(action);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

