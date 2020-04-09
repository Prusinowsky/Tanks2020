package app.windows.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameHudComponent extends JComponent {

    private JLabel lTime, lHeart[], lLogo;
    private JButton bPause, bExit;
    private Boolean resize;

    public GameHudComponent(){
        setLayout(null);

        render();
        setRefreshTime();
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                if(resize) {
                    resize = false;
                    render();
                }
            }
        });
    }

    /**
     * Ustawia time-delay do odświeżania mapy
     */
    protected void setRefreshTime(){
        resize = false;
        java.util.Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                resize = true;
            }
        }, 0, 500);
    }

    /**
     * Metoda renderująca HUD'a
     */

    public void render()
    {
        removeAll();

        lLogo = new JLabel("TANK 2020");
        lLogo.setBounds(25,20,50,50);
        add(lLogo);

        lTime = new JLabel("0:01:34");           //czas do końca gry będzie ustalany przez silnik
        lTime.setBounds(25,80, 80,20);
        add(lTime);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lHeart = new JLabel[numberOfLifes];
        ImageIcon picHeart = new ImageIcon("assets/textures/hud/life.png");

        for (Integer i=0; i<numberOfLifes; i++)
        {
            lHeart[i] = new JLabel(picHeart);
            lHeart[i].setBounds(20 + 20*i,120,20,20);
            add(lHeart[i]);
        }

        //Integer y = 800; //powinien być getHeight() ale coś nie styka XD
        Integer y = getHeight();

        bPause = new JButton("Pause");
        bPause.setBounds(20, y - 150, 80,20);
        add(bPause);

        bExit = new JButton("Exit");
        bExit.setBounds(20,y - 120,80,20);
        add(bExit);

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

