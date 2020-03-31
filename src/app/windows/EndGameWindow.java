package app.windows;

import app.actions.ExitWindowAction;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;

public class EndGameWindow extends JFrame implements WindowInterface
{
    private JLabel lInfo;
    private JButton bOkey;

    public EndGameWindow()
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
        bOkey.addActionListener(new ExitWindowAction(this));
    }

    public void open()
    {
        //EndGameFrame frame = new EndGameFrame();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void close()
    {
        dispose();
    }
}
