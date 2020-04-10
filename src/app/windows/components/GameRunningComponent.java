package app.windows.components;

import app.config.interfaces.ConfigInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Komponent odpowiadajacy za renderowanie gry
 */
public class GameRunningComponent extends JComponent {

    private Boolean resize;
    private ConfigInterface config;

    /**
     * Konstruktor Domyslny
     * @param config
     */
    public GameRunningComponent(ConfigInterface config){
        super();
        this.config = config;
        setSize(new Dimension(500,700));
        setLayout(null);
        setVisible(true);
        setRefreshTime();

        render();
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                if(resize) {
                    resize = false;
                    render();
                }
            }
        });
    }

    /**
     * Ustawia time-delay do odświeżania mapy
     */
    protected void setRefreshTime(){
        resize = false;
        java.util.Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                resize = true;
            }
        }, 0, 100);
    }


    public void render(){
        removeAll();

        GameMapComponent map = new GameMapComponent(config);
        map.setBounds(0,0,(int)(getWidth()*0.8),getHeight());
        map.setSize(new Dimension((int)(getWidth()*0.8),getHeight()));
        map.render();
        add(map);

        GameHudComponent hud = new GameHudComponent(config);
        hud.setBounds((int)(getWidth()*0.8),(int)(getHeight()*0.05),(int)(getWidth()*0.2), getHeight());
        hud.setSize(new Dimension((int)(getWidth()*0.18), (int)(getHeight()*0.9)));
        hud.render();
        add(hud);

        setVisible(true);
        repaint();
    }


}
