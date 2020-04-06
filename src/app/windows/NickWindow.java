package app.windows;
import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Okno wybory Nicku
 */
public class NickWindow extends JFrame implements WindowInterface
{
    private JLabel lNickTitle;
    private JTextField tNickname;
    private JButton bOk, bCancel;

    GameWindow gameFrame = new GameWindow();

    /**
     * Konstrukor odpowiadający za inicjalizację okna wyboru Nicku
     */
    public NickWindow()
    {
        Config config = Config.getInstance();

        setSize(300,250);
        setTitle(config.getProperty("nick_window_title"));
        setLayout(null);

        lNickTitle = new JLabel(config.getProperty("set_nick"));
        lNickTitle.setBounds(70,30,160,40);
        lNickTitle.setFont(new Font("SansSerif",Font.BOLD,18));
        add(lNickTitle);

        tNickname = new JTextField("");
        tNickname.setBounds(50,80,180,20);
        add(tNickname);

        bOk = new JButton(config.getProperty("ok"));
        bOk.setBounds(50,130,80,20);
        add(bOk);
        bOk.addActionListener(new ExitWindowAction(this));
        bOk.addActionListener(new OpenWindowAction(gameFrame));

        bCancel = new JButton(config.getProperty("cancel"));
        bCancel.setBounds(150,130,80,20);
        add(bCancel);
        bCancel.addActionListener(new ExitWindowAction(this));

        centreWindow(this);
    }

    /**
     * Metoda centrująca położenie okna
     * @param frame Zawiera przekazane okno
     */
    public static void centreWindow(NickWindow frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    /**
     * Metoda implementująca otwarcie okna
     */
    public void open()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Metoda implementująca zamknięcie okna
     */
    public void close()
    {
        dispose();
    }

}
