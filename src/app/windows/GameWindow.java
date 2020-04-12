package app.windows;

import app.Container;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;
import app.windows.components.MenuBarComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Główne okno aplikacji - STARTOWE (MENU)
 */
@SuppressWarnings("serial")
public class GameWindow extends AbstractWindow
{
    private ConfigInterface config;
    private MenuBarComponent menuBar;

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

        menuBar = new MenuBarComponent(config);
        setJMenuBar(menuBar.getJMenuBar());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        centreWindow();
    }


    public void addMenuStartActionListener(ActionListener action){
        menuBar.addStartActionListener(action);
    }

    public void addMenuMapChooseActionListener(ActionListener action){
        menuBar.addMapChooseActionListener(action);
    }

    public void addMenuScoreActionListener(ActionListener action){
        menuBar.addScoreActionListener(action);
    }

    public void addMenuAboutActionListener(ActionListener action){
        menuBar.addAboutActionListener(action);
    }

    public void addMenuExitActionListener(ActionListener action){
        menuBar.addExitActionListener(action);
    }

}
