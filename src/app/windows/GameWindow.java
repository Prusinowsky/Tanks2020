package app.windows;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameWindow extends JFrame implements WindowInterface
{
    public GameWindow()
    {
        setSize(800,800);
        setTitle("Okno gry");
        setLayout(null);
    }

    public void open()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void close()
    {
        dispose();
    }

}
