package app.display.components;

import app.Container;
import app.config.ConfigInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Klasa odpowiedzialna za komponent paska menu
 */
public class MenuBarComponent extends JMenuBar {

    private ConfigInterface config;

    private JMenuBar jmenuBar;
    private JMenu menuFile, menuHelp;
    private JMenuItem mStart, mMode, mMap, mScore, mExit, mAbout;

    /**
     * Kontruktor domyslny
     * @param config Obiekt konfiguracyjny
     */
    public MenuBarComponent(ConfigInterface config){
        super();
        this.config = config;

        jmenuBar = new JMenuBar();
        menuFile = new JMenu(config.getProperty("game"));
        mStart = new JMenuItem(config.getProperty("start"));
        mMode = new JMenuItem("Online");
        mMap = new JMenuItem(config.getProperty("choose_map"));
        mScore = new JMenuItem(config.getProperty("best_scores"));
        mExit = new JMenuItem(config.getProperty("exit"));

        jmenuBar.add(menuFile);
        jmenuBar.add(Box.createHorizontalGlue());
        menuFile.add(mStart);
        menuFile.add(mMode);
        menuFile.add(mMap);
        menuFile.add(mScore);
        menuFile.add(mExit);

        menuHelp = new JMenu(config.getProperty("help"));
        mAbout = new JMenuItem(config.getProperty("about"));

        menuHelp.add(mAbout);
        jmenuBar.add(menuHelp);

    }

    public void addStartActionListener(ActionListener action){
        mStart.addActionListener(action);
    }

    public void addModeActionListener(ActionListener action){
        mMode.addActionListener(action);
    }

    public void addMapChooseActionListener(ActionListener action){
        mMap.addActionListener(action);
    }

    public void addScoreActionListener(ActionListener action){
        mScore.addActionListener(action);
    }

    public void addAboutActionListener(ActionListener action){
        mAbout.addActionListener(action);
    }

    public void addExitActionListener(ActionListener action){
        mExit.addActionListener(action);
    }

    /**
     * Zwraca obiekt JMenuBar
     * @return JMenuBar
     */
    public JMenuBar getJMenuBar() {
        return jmenuBar;
    }
}
