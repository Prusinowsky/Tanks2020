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

    private JLabel lNick, lScore, lTime, lLabelHeart, lHeart[], lLogo;
    private JButton bPause, bResume, bExit;

    public String playerName = "";
    public String time = "";
    public Integer score = 0;
    public Integer lifes = 3;

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

        lNick = new JLabel(Container.getInstance().provideOptions().nickname);
        lNick.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lNick);

        lTime = new JLabel(config.getProperty("time") + ": " +  "01:34");
        lTime.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(lTime);

        lScore = new JLabel(config.getProperty("score") + ":");
        lScore.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(lScore);

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

        bResume = new JButton(config.getProperty("resume"));
        bResume.setVisible(false);
        add(bResume);

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
        lNick.setBounds(10,160,getWidth(),30);
        lNick.setText(this.playerName);
        lTime.setBounds( 10,190, getWidth(),30);
        lTime.setText(config.getProperty("time") + ": " +  this.time);
        lScore.setBounds(10,220,getWidth(),30);
        lScore.setText(config.getProperty("score") + ": " + this.score);

        lLabelHeart.setBounds(10, 250, getWidth(), 30);
        for (Integer i=0; i < 3; i++)
        {
            lHeart[i].setVisible(false);
        }

        for (Integer i=0; i < lifes; i++)
        {
            lHeart[i].setBounds(  getWidth()/2 + 30*i - 45,280,30,30);
            lHeart[i].setVisible(true);
        }

        Integer y = getHeight();
        bPause.setBounds( (int)(getWidth()*0.1), y - 120, (int)(getWidth()*0.8),40);
        bResume.setBounds( (int)(getWidth()*0.1), y - 120, (int)(getWidth()*0.8),40);
        bExit.setBounds( (int)(getWidth()*0.1),y - 60,(int)(getWidth()*0.8),40);

    }

    public void setPlayerName(String name){
        this.playerName = name;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public void setLifes(Integer lifes){
        this.lifes = lifes;
    }

    /**
     * Metoda aktualizująca okno
     */
    @Override
    public void update() {
        revalidate();
        repaint();
    }

    public void showResume(){
        bResume.setVisible(true);
    }

    public void showPause(){
        bPause.setVisible(true);
    }

    public void hideResume(){
        bResume.setVisible(false);
    }

    public void hidePause(){
        bPause.setVisible(false);
    }

    /**
     * Meotda dodająca akację dla przycisku pauzy
     * @param action Przypisywana akcja
     */
    public void addPauseActionListener(ActionListener action){
        bPause.addActionListener(action);
    }

    /**
     * Meotda dodajaca akcje dla przycisku wznowienia
     * @param action wznow
     */
    public void addResumeActionListener(ActionListener action){
        bResume.addActionListener(action);
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

