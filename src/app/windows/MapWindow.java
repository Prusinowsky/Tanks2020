package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;

public class MapWindow extends JFrame implements WindowInterface
{
    private JLabel lSelectMap;
    private JButton bOkey, bCancel;

    public MapWindow()
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
        bOkey.addActionListener(new ExitWindowAction(this));

        bCancel = new JButton("Anuluj");
        bCancel.setBounds(150,120,80,20);
        add(bCancel);
        bCancel.addActionListener(new OpenWindowAction(this));
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
