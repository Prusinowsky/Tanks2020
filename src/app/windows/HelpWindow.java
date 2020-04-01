package app.windows;
import app.actions.ExitWindowAction;
import app.config.Config;
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
        Config config = Config.getInstance();

        setSize(400,300);
        setTitle(config.getProperty("about"));
        setLayout(null);

        lAbout = new JLabel(config.getProperty("game_description"));
        lAbout.setBounds(50,50,200,20);
        add(lAbout);

        bOkey = new JButton(config.getProperty("ok"));
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
