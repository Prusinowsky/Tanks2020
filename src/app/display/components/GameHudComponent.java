package app.display.components;

import app.Container;
import app.config.ConfigInterface;
import app.engine.interfaces.Renderable;
import app.loaders.texture.TextureLoaderInterface;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * Komponent odpowiadający za renderowanie HUD-a
 */
public class GameHudComponent extends JPanel implements Renderable {

    private ConfigInterface config;
    private TextureLoaderInterface textureLoader;

    private JLabel lTime, lLabelHeart, lHeart[], lLogo;
    private JButton bPause, bExit;

    /**
     * Konstrukotr dymyślny
     * @param config Obiekt konfiguracyjny
     */
    public GameHudComponent(ConfigInterface config){

        this.config = Container.getInstance().provideConfig();
        this.textureLoader = Container.getInstance().provideTextureLoader();

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
        lLogo = new JLabel(new ImageIcon(textureLoader.getTextureImageScaled("Logo", 200, 130, Image.SCALE_DEFAULT)));
        add(lLogo);

        lTime = new JLabel(config.getProperty("time") +  " 0:01:34");
        lTime.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(lTime, SwingConstants.CENTER);

        Integer numberOfLifes = 3; //będzie pobierana z opcji
        lLabelHeart = new JLabel(config.getProperty("lives") + ":");
        lLabelHeart.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(lLabelHeart);
        lHeart = new JLabel[numberOfLifes];
        for (Integer i=0; i<numberOfLifes; i++)
        {
            ImageIcon picHeart = new ImageIcon(textureLoader.getTextureImageScaled("Life", 30, 30, Image.SCALE_DEFAULT));
            lHeart[i] = new JLabel(picHeart);
            add(lHeart[i]);
        }

        setFocusable(false);

        bPause = new JButton(config.getProperty("pause"));
        add(bPause);


        bExit = new JButton(config.getProperty("back"));
        add(bExit);
    }

    /**
     * Metoda renderująca HUD'a
     */
    public void render()
    {
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

//        bPause.key
//        System.out.println(bPause.getRegisteredKeyStrokes());

        revalidate();
        repaint();
    }

    /**
     * Metoda aktualizująca okno
     */
    @Override
    public void update() {

    }

    /**
     * Meotda dodająca akację dla przycisku pauzy
     * @param action Przypisywana akcja
     */
    public void addPauseActionListener(ActionListener action){
        bPause.addActionListener(action);
    }

    /**
     * Meotda dodająca akację dla przycisku exit
     * @param action Przypisywana akcja
     */
    public void addExitActionListener(ActionListener action){
        bExit.addActionListener(action);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

