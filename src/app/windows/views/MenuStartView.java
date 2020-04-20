package app.windows.views;

import app.Container;
import app.config.ConfigInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;


public class MenuStartView extends JPanel {

    private ConfigInterface config;
    private JButton bStart, bExit;

    /**
     * Konstrukor Domyslny
     */
    public MenuStartView(){
        this.config = Container.getInstance().provideConfig();
        setLayout(null);
        setVisible(true);

        init();
        handleResizing();
    }

    /**
     * Metoda odpowiadająca za inicjalizację stanu
     */
    private void init(){
        bStart = new JButton("Start");
        add(bStart);

        bExit = new JButton("Wyjdź z gry");
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

        File file = new File("assets/welcome.png");
        try {
            Image image = ImageIO.read(file).getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
            g2d.drawImage(image, 0 , 0 , null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addStartActionListener(ActionListener action){
        bStart.addActionListener(action);
    }

    public void addExitActionListener(ActionListener action){
        bExit.addActionListener(action);
    }

}
