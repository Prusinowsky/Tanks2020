package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MapFrame extends JFrame implements ActionListener
{
    private JLabel lSelectMap;
    private JButton bOkey, bCancel;

    public MapFrame()
    {
        setSize(400,300);
        setTitle("Wybierz mapę");
        setLayout(null);

        lSelectMap = new JLabel("Tu będzie wybór mapy, jeszcze nie wiem jak zrobić taki pasek otwierający xD");
        lSelectMap.setBounds(50,50,200,50);
        add(lSelectMap);

        bOkey = new JButton("OK");
        bOkey.setBounds(50,120,80,20);
        add(bOkey);
        bOkey.addActionListener(this);

        bCancel = new JButton("Anuluj");
        bCancel.setBounds(150,120,80,20);
        add(bCancel);
        bCancel.addActionListener(this);
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
            /*Zmieni sie mapa*/
        }
        else if(source==bCancel)
        {
            close();
        }
    }
}
