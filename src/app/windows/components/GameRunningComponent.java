package app.windows.components;

import app.config.interfaces.ConfigInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameRunningComponent extends JComponent {

    private Boolean resize;
    private ConfigInterface config;

    public GameRunningComponent(ConfigInterface config){
        super();
        this.config = config;
        setLayout(new BorderLayout());

        render();
        setRefreshTime();
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
        }, 0, (int)1000/30);
    }


    public void render(){
        removeAll();

        GameMapComponent map = new GameMapComponent(config, getWidth(), getHeight(), 0.8);
        add(map);

        GameHudComponent hud = new GameHudComponent(config, getWidth(), getHeight(), 0.2);
        add(hud);

        revalidate();
        repaint();
    }


}
