package app.windows.components;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.windows.GameWindow;
import app.windows.NickWindow;
import app.windows.abstracts.AbstractStateComponent;

import javax.swing.*;
import java.awt.*;

public class MenuStartComponent extends AbstractStateComponent {

    private GameWindow gameWindow;
    private NickWindow nickWindow;

    public MenuStartComponent(GameWindow gameWindow, NickWindow nickWindow){
        super();
        this.gameWindow = gameWindow;
        this.nickWindow = nickWindow;
        setLayout(new GridBagLayout());

    }

    /**
     * Metoda odpowiadająca za inicjalizację stanu
     */
    public void start(){

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;

        JLabel welcome = new JLabel();
        welcome.setText("TANKS 2020");
        c.gridx = 0;
        c.gridy = 0;
        add(welcome, c);

        JButton start = new JButton("Start");
        start.addActionListener(new OpenWindowAction(nickWindow));
        c.gridx = 0;
        c.gridy = 1;
        add(start, c);

        JButton exit = new JButton("Wyjdź z gry");
        exit.addActionListener(new ExitWindowAction(gameWindow));
        c.gridx = 0;
        c.gridy = 2;
        add(exit, c);

    }
}
