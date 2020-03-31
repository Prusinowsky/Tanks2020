package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NickFrame extends JFrame implements ActionListener
{
    private JLabel lNickTitle;
    private JTextField tNickname;
    private JButton bOk, bCancel;

    GameFrame gameFrame = new GameFrame();

    public NickFrame()
    {
        setSize(300,250);
        setTitle("Nick");
        setLayout(null);

        lNickTitle = new JLabel("Podaj swój nick");
        lNickTitle.setBounds(70,30,160,40);
        lNickTitle.setFont(new Font("SansSerif",Font.BOLD,18));
        add(lNickTitle);

        tNickname = new JTextField("");
        tNickname.setBounds(50,80,180,20);
        add(tNickname);

        bOk = new JButton("OK");
        bOk.setBounds(50,130,80,20);
        add(bOk);
        bOk.addActionListener(this);

        bCancel = new JButton("Anuluj");
        bCancel.setBounds(150,130,80,20);
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
        if(source==bOk)
        {
            gameFrame.run();
            close();
        }
        else if(source==bCancel)
        {
            close();
        }
    }
}
