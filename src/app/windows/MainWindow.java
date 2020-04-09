package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.components.GameHudComponent;
import app.windows.components.GameMapComponent;
import app.windows.components.MenuBarComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Główne okno aplikacji - STARTOWE (MENU)
 */
@SuppressWarnings("serial")
public class MainWindow extends AbstractWindow
{

    ScoreWindow scoreFrame = new ScoreWindow();
    MapWindow mapFrame = new MapWindow();
    HelpWindow helpFrame = new HelpWindow();
    NickWindow nickFrame = new NickWindow();

    /**
     * Kontruktor inicjalizujący główne okno apliakcji
     */
    public MainWindow()
    {
        Config config = Config.getInstance();

        setSize(800,800);
        setTitle(config.getProperty("title"));

        setLayout(new GridLayout());

        MenuBarComponent menuBar = new MenuBarComponent(config);
        menuBar.addStartActionListener(new OpenWindowAction(nickFrame));
        menuBar.addMapActionListener(new OpenWindowAction(mapFrame));
        menuBar.addScoreActionListener(new OpenWindowAction(scoreFrame));
        menuBar.addAboutActionListener(new OpenWindowAction(helpFrame));
        menuBar.addExitActionListener(new ExitWindowAction(this));
        setJMenuBar(menuBar.getJMenuBar());

        GameMapComponent gameMap = new GameMapComponent(config);
        add(gameMap);

        GameHudComponent gameHud = new GameHudComponent();
        add(gameHud);

        centreWindow();
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
