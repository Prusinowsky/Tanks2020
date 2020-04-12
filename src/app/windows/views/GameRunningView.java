package app.windows.views;

import app.config.ConfigInterface;
import app.windows.GameWindow;
import app.windows.abstracts.AbstractStateComponent;
import app.windows.components.GameHudComponent;
import app.windows.components.GameMapComponent;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Komponent odpowiadajacy za renderowanie gry
 */
public class GameRunningView extends AbstractStateComponent {

    private ConfigInterface config;
    private GameWindow gameWindow;

    /**
     * Konstruktor Domyslny
     * @param config
     */
    public GameRunningView(GameWindow gameWindow, ConfigInterface config){
        super();
        this.config = config;
        this.gameWindow = gameWindow;

        setSize(new Dimension(500,700));
        setLayout(null);
        setVisible(true);

        resizeHandler();
    }

    /**
     * Obsluga zmiany rozdzielczości okna
     */
    public void resizeHandler(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                render();
            }
        });
    }

    /**
     * Metoda inicjalizujaca start stanu
     */
    public void start(){
        render();
    }

    /**
     * Renderowanie okna
     */
    public void render(){
        removeAll();

        GameMapComponent map = new GameMapComponent(config);
        map.setBounds(0,0,(int)(getWidth()*0.8),getHeight());
        map.setSize(new Dimension((int)(getWidth()*0.8),getHeight()));
        map.renderPeriodically();
        add(map);

        GameHudComponent hud = new GameHudComponent(config, gameWindow);
        hud.setBounds((int)(getWidth()*0.8),(int)(getHeight()*0.05),(int)(getWidth()*0.2), getHeight());
        hud.setSize(new Dimension((int)(getWidth()*0.18), (int)(getHeight()*0.9)));
        hud.render();
        add(hud);

        setVisible(true);
        repaint();
    }


}
