package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EndGameFrame extends JFrame implements ActionListener, Window
{
    private JLabel lInfo;
    private JButton bOkey;

    public EndGameFrame()
    {
        setSize(400,300);
        setTitle("Przegrałeś");
        setLayout(null);

        lInfo = new JLabel("Przegrałeś twój wynik to: *jakaś wartość*");
        lInfo.setBounds(50,50,200,20);
        add(lInfo);

        bOkey = new JButton("OK");
        bOkey.setBounds(110,80,80,20);
        add(bOkey);
        bOkey.addActionListener(this);
    }

    public void run()
    {
        //EndGameFrame frame = new EndGameFrame();
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
        Object source = e.getSource();
        if(source==bOkey)
        {
            close();
        }
    }
}
