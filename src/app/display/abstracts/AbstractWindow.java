package app.display.abstracts;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa abstrakcyjna zawierająca metody pomocnicze
 */
 @SuppressWarnings("serial")
public abstract class AbstractWindow extends JFrame {

    /**
     * Metoda centrująca położenie okna
     */
    public void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}
