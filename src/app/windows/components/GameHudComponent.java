package app.windows.components;

import app.config.interfaces.ConfigInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameHudComponent extends JComponent {

    private Integer anchorPointX, anchorPointY;

    private JLabel lTime, lHeart[], lLogo;
    private JButton bPause, bExit;

    public GameHudComponent(ConfigInterface config, Integer width, Integer height, Double percent){
        setLayout(null);

        setSize((int)(width*percent), height);
        this.anchorPointX = (int)(width*(1-percent));
        this.anchorPointY = 0;

        render();
    }

    /**
     * Metoda renderująca HUD'a
     */

    public void render()
    {
        removeAll();

        lLogo = new JLabel("TANK 2020");
        lLogo.setBounds(anchorPointX + 25,20,50,50);
        add(lLogo);

        lTime = new JLabel("0:01:34");           //czas do końca gry będzie ustalany przez silnik
        lTime.setBounds(anchorPointX + 25,80, 80,20);
        add(lTime);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lHeart = new JLabel[numberOfLifes];
        ImageIcon picHeart = new ImageIcon("assets/textures/hud/life.png");

        for (Integer i=0; i<numberOfLifes; i++)
        {
            lHeart[i] = new JLabel(picHeart);
            lHeart[i].setBounds(anchorPointX + 20 + 20*i,120,20,20);
            add(lHeart[i]);
        }

        Integer y = getHeight();

        bPause = new JButton("Pause");
        bPause.setBounds(anchorPointX + 20, y - 150, 80,20);
        add(bPause);

        bExit = new JButton("Exit");
        bExit.setBounds(anchorPointX + 20,y - 120,80,20);
        add(bExit);

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

