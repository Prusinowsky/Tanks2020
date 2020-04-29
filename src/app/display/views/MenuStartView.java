package app.display.views;

import app.Container;
import app.config.ConfigInterface;
import app.loaders.texture.TextureLoaderInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MenuStartView extends JPanel {

    private ConfigInterface config;
    private TextureLoaderInterface textureLoader;

    private JButton bStart, bExit;

    /**
     * Konstrukor Domyslny
     */
    public MenuStartView(){
        this.config = Container.getInstance().provideConfig();
        this.textureLoader = Container.getInstance().provideTextureLoader();

        setLayout(null);
        setVisible(true);

        init();
        handleResizing();
    }

    /**
     * Metoda odpowiadająca za inicjalizację stanu
     */
    private void init(){
        bStart = new JButton(config.getProperty("start"));
        add(bStart);

        bExit = new JButton(config.getProperty("exit"));
        add(bExit);
    }

    private void handleResizing(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                render();
            }
        });
    }

    private void render(){
        Integer width = 150;
        Integer height = 25;

        bStart.setBounds(getWidth()/2 - width/2, getHeight()/2 - height/2, width, height);
        bExit.setBounds(getWidth()/2 - width/2, getHeight()/2 - height/2 + 40, width, height);
    }

    /**
     * Metoda odpowiadajaca za rysowanie mapy
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        Image image = textureLoader.getTexture("Background").image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
        g2d.drawImage(image, 0 , 0 , null);


    }

    public void addStartActionListener(ActionListener action){
        bStart.addActionListener(action);
    }

    public void addExitActionListener(ActionListener action){
        bExit.addActionListener(action);
    }

}
