package app.windows;
import app.Container;
import app.actions.ChangeStateAction;
import app.actions.ExitWindowAction;
import app.config.ConfigInterface;
import app.windows.abstracts.AbstractWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Okno wybory Nicku
 */
@SuppressWarnings("serial")
public class SetNickWindow extends AbstractWindow
{
    private ConfigInterface config;
    private GameWindow gameWindow;
    private GridBagConstraints gbc = new GridBagConstraints();

    private JLabel lNickTitle;
    private JTextField tNickname;
    private JButton bOk, bCancel;

    /**
     * Konstrukor odpowiadający za inicjalizację okna wyboru Nicku
     */
    public SetNickWindow(GameWindow gameWindow)
    {
        config = Container.getInstance().provideConfig();
        this.gameWindow = gameWindow;

        setSize(300,250);
        setTitle(config.getProperty("nick_window_title"));

        GridBagLayout gridbag = new GridBagLayout();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        addNickLabel();
        addNickInput();
        addCancelBtn();
        addOkBtn();

        centreWindow();
    }

    /**
     * Metoda dodająca etykietę wyboru pseudonimu
     */
    private void addNickLabel(){
        lNickTitle = new JLabel(config.getProperty("set_nick"));
        lNickTitle.setFont(new Font("SansSerif",Font.BOLD,16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lNickTitle, gbc);
    }

    /**
     * Metoda dodająca pole tekstowe
     */
    private void addNickInput(){
        tNickname = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(tNickname, gbc);
    }

    /**
     * Metoda dodająca przycisk anuluj
     */
    private void addCancelBtn(){
        bCancel = new JButton(config.getProperty("cancel"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(bCancel, gbc);
        bCancel.addActionListener(new ExitWindowAction(this));
    }

    /**
     * Metoda dodająca przycisk ok
     */
    private void addOkBtn(){
        bOk = new JButton(config.getProperty("ok"));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(bOk, gbc);
        bOk.addActionListener(new ExitWindowAction(this));
        bOk.addActionListener(new ChangeStateAction(gameWindow, "running"));
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
