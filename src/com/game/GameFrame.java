package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameFrame extends JFrame implements ActionListener
{
    public GameFrame()
    {
        setSize(800,800);
        setTitle("Okno gry");
        setLayout(null);
    }

    public void run()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void close()
    {
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
