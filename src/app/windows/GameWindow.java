package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.components.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

/**
 * Główne okno aplikacji - STARTOWE (MENU)
 */
@SuppressWarnings("serial")
public class GameWindow extends AbstractWindow
{
    private String currentState;
    private HashMap <String, JComponent> states = new HashMap<String, JComponent>();

    private ScoreWindow scoreFrame;
    private MapWindow mapFrame;
    private HelpWindow helpFrame;
    private NickWindow nickFrame;

    /**
     * Kontruktor inicjalizujący główne okno apliakcji
     */
    public GameWindow()
    {
        Config config = Config.getInstance();

        setSize(1000,700);
        setTitle(config.getProperty("title"));
        setLayout(new BorderLayout());
        setVisible(true);

        init();
        initStates();
        this.currentState = "menu";

        MenuBarComponent menuBar = new MenuBarComponent(config);
        menuBar.addStartActionListener(new OpenWindowAction(nickFrame));
        menuBar.addMapActionListener(new OpenWindowAction(mapFrame));
        menuBar.addScoreActionListener(new OpenWindowAction(scoreFrame));
        menuBar.addAboutActionListener(new OpenWindowAction(helpFrame));
        menuBar.addExitActionListener(new ExitWindowAction(this));
        setJMenuBar(menuBar.getJMenuBar());

        centreWindow();
        render();
    }


    public void init(){
        scoreFrame = new ScoreWindow();
        mapFrame = new MapWindow();
        helpFrame = new HelpWindow();
        nickFrame = new NickWindow(this);
    }

    public void initStates(){
        Config config = Config.getInstance();

        states.put("menu", new MenuStartComponent(this, nickFrame));
        states.put("running", new GameRunningComponent(config));

    }

    public void render(){
        JComponent newState = states.get(currentState);
        newState.setSize(new Dimension((int)(getWidth() * 0.95), (int)(getHeight()*0.9)));
        add(newState);
        repaint();
    }

    public void changeState(String stateName){
        remove(states.get(currentState)); // Delete previous state
        this.currentState  = stateName;
        render();
    }

    /**
     * Metoda implementująca otwarcie okna
     */
    public void open()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
