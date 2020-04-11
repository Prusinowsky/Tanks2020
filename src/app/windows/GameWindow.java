package app.windows;

import app.Container;
import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractStateComponent;
import app.windows.abstracts.AbstractWindow;
import app.windows.components.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Główne okno aplikacji - STARTOWE (MENU)
 */
@SuppressWarnings("serial")
public class GameWindow extends AbstractWindow
{
    private ConfigInterface config;

    private String currentState;
    private HashMap <String, AbstractStateComponent> states = new HashMap<String, AbstractStateComponent>();

    private ScoreWindow scoreFrame;
    private MapWindow mapFrame;
    private HelpWindow helpFrame;
    private NickWindow nickFrame;

    /**
     * Kontruktor inicjalizujący główne okno apliakcji
     */
    public GameWindow()
    {
        config = Container.getInstance().provideConfig();

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


    /**
     * Metoda inicjalizujaca
     */
    public void init(){
        scoreFrame = new ScoreWindow();
        mapFrame = new MapWindow(this);
        helpFrame = new HelpWindow();
        nickFrame = new NickWindow(this);
    }

    /**
     * Metoda inicjalizująca stany
     */
    public void initStates(){
        states.put("menu", new MenuStartComponent(this, nickFrame));
        states.put("running", new GameRunningComponent( this, config));
    }

    /**
     * Meotda odpowiadajaca za renderowanie aktywnego statnu
     */
    public void render(){
        AbstractStateComponent newState = states.get(currentState);
        newState.setSize(new Dimension((int)(getWidth() * 0.95), (int)(getHeight()*0.9)));
        newState.start();
        add(newState);
        repaint();
    }

    /**
     * Metoda odpowiadajaca za zmiane stanu
     * @param stateName
     */
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
