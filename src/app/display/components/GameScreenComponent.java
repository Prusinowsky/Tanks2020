package app.display.components;

import javax.swing.*;
import java.awt.*;

/**
 * Komponent zawierajacy renderujacy mapę
 */
public class GameScreenComponent extends JPanel{

    private Image screen;

    /**
     * Konstrukor Domyslny
     */
    public GameScreenComponent(){
        setLayout(null);
        setSize(new Dimension(500, 500));

        setVisible(true);
    }

    /**
     * Ustawianie nowego obrazu :)
     * @param screen
     */
    public void setScreen(Image screen){
        this.screen = screen;
    }

    /**
     * Metoda odpowiadajaca za rysowanie mapy
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(screen != null) {
            Integer min = (int) (Math.min(getWidth(), getHeight()) * 0.95);
            Image imageScreenScaled = screen.getScaledInstance(min, min, Image.SCALE_DEFAULT);

            Integer offsetX = (getWidth() - imageScreenScaled.getWidth(null)) >> 1;
            Integer offsetY = (getHeight() - imageScreenScaled.getHeight(null)) >> 1;

            g.drawImage(imageScreenScaled, offsetX, offsetY, imageScreenScaled.getWidth(null), imageScreenScaled.getWidth(null), null);
        }
    }


}
