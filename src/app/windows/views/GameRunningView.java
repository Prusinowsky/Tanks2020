package app.windows.views;

import app.Container;
import app.config.ConfigInterface;
import app.windows.components.GameHudComponent;
import app.windows.components.GameMapComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Komponent odpowiadajacy za renderowanie gry
 */
public class GameRunningView extends JComponent {

    private ConfigInterface config;

    private GameMapComponent map;
    private GameHudComponent hud;

    /**
     * Konstruktor Domyslny
     */
    public GameRunningView(){
        super();
        this.config = Container.getInstance().provideConfig();

        setSize(new Dimension(500,700));
        setLayout(null);
        setVisible(true);

        init();
        handleResizing();
        render();
    }

    /**
     * Obsluga zmiany rozdzielczości okna
     */
    public void handleResizing(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                render();
            }
        });
    }


    public void init(){
        map = new GameMapComponent(config);
        add(map);

        hud = new GameHudComponent(config);
        add(hud);
    }
    /**
     * Renderowanie okna
     */
    public void render(){
        map.setBounds(0,0,(int)(getWidth()*0.8),getHeight());
        map.setSize(new Dimension((int)(getWidth()*0.8),getHeight()));
        map.renderPeriodically();

        hud.setBounds((int)(getWidth()*0.8),(int)(getHeight()*0.05),(int)(getWidth()*0.2), getHeight());
        hud.setSize(new Dimension((int)(getWidth()*0.18), (int)(getHeight()*0.9)));
        hud.render();

        repaint();
    }

    public void addHudPauseActionListener(ActionListener action){
        hud.addPauseActionListener(action);
    }

    public void addHudExitActionListener(ActionListener action){
        hud.addExitActionListener(action);
    }

}
