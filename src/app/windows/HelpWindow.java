package app.windows;
import app.actions.ExitWindowAction;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class HelpWindow extends JFrame implements WindowInterface
{
    private JLabel lAbout;
    private JButton bOkey;

    public HelpWindow()
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
        bOkey.addActionListener(new ExitWindowAction(this));
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
