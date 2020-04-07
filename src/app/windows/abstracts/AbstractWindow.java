package app.windows.abstracts;

import app.windows.NickWindow;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa abstrakcyjna zawierająca metody pomocnicze
 */
abstract public class AbstractWindow extends JFrame implements WindowInterface {

    /**
     * Metoda odpowiedzialna za otwarcie okna
     */
    abstract public void open();

    /**
     * Metoda odpowiedzialna za zakmnięcie okna
     */
    abstract public void close();

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
