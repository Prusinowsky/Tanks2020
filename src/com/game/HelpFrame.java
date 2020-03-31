package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class HelpFrame extends JFrame implements ActionListener
{
    private JLabel lAbout;
    private JButton bOkey;

    public HelpFrame()
    {
        setSize(400,300);
        setTitle("O programie");
        setLayout(null);

        lAbout = new JLabel("Tu będzie opis gry, itp");
        lAbout.setBounds(50,50,200,20);
        add(lAbout);

        bOkey = new JButton("OK");
        bOkey.setBounds(110,80,80,20);
        add(bOkey);
        bOkey.addActionListener(this);
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
        Object source = e.getSource();
        if(source==bOkey)
        {
            close();
        }
    }
}
