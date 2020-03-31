package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ScoreFrame extends JFrame implements ActionListener
{
    private JLabel lList;
    private JButton bOkey;

    public ScoreFrame()
    {
        setSize(400,300);
        setTitle("Najlepsze wyniki");
        setLayout(null);

        lList = new JLabel("Tu będzie kiedyś lista wyników");
        lList.setBounds(50,50,200,20);
        add(lList);

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
