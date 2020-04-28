package app.windows.components;

import app.Container;
import app.config.ConfigInterface;
import app.engine.interfaces.Renderable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Komponent odpowiadający za renderowanie HUD-a
 */
public class GameHudComponent extends JPanel implements Renderable {

    private JLabel lTime, lLabelHeart, lHeart[], lLogo;
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
        lLogo = new JLabel(new ImageIcon(new ImageIcon("assets/logo.png").getImage().getScaledInstance(200, 130, Image.SCALE_DEFAULT)));
        add(lLogo);

        lTime = new JLabel("Czas: " +  "0:01:34");
        lTime.setFont(new Font("Arial Black", Font.PLAIN, 20));
        add(lTime, SwingConstants.CENTER);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lLabelHeart = new JLabel("Życia:");
        lLabelHeart.setFont(new Font("Arial Black", Font.PLAIN, 20));
        add(lLabelHeart);
        lHeart = new JLabel[numberOfLifes];
        for (Integer i=0; i<numberOfLifes; i++)
        {
            ImageIcon picHeart = new ImageIcon(new ImageIcon("assets/textures/hud/life.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
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
        //lLogo = new JLabel(new ImageIcon(new ImageIcon("assets/logo.png").getImage().getScaledInstance(getWidth(), 200, Image.SCALE_DEFAULT)));
        lLogo.setBounds( 0,0,getWidth(),140);
        lTime.setBounds( 10,160, getWidth(),30);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lLabelHeart.setBounds(10, 190, getWidth(), 30);
        for (Integer i=0; i<numberOfLifes; i++)
        {
            lHeart[i].setBounds(  getWidth()/2 + 30*i - 45,220,30,30);
        }

        Integer y = getHeight();
        bPause.setBounds( (int)(getWidth()*0.1), y - 120, (int)(getWidth()*0.8),40);
        bExit.setBounds( (int)(getWidth()*0.1),y - 60,(int)(getWidth()*0.8),40);

        revalidate();
        repaint();
    }

    @Override
    public void update() {

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

