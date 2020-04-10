package app.windows;
import app.actions.ChangeStateAction;
import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.abstracts.AbstractWindow;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Okno wybory Nicku
 */
@SuppressWarnings("serial")
public class NickWindow extends AbstractWindow
{
    private JLabel lNickTitle;
    private JTextField tNickname;
    private JButton bOk, bCancel;

    /**
     * Konstrukor odpowiadający za inicjalizację okna wyboru Nicku
     */
    public NickWindow(GameWindow gameWindow)
    {
        Config config = Config.getInstance();

        setSize(300,250);
        setTitle(config.getProperty("nick_window_title"));

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        gridbag.columnWidths = new int[]{120,120};
        gridbag.rowHeights = new int[]{35, 35};
        setLayout(gridbag);

        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.BOTH;

        addNickLabel(config.getProperty("set_nick"), c,null);
        addNickInput("", c,null);
        addCancelBtn(config.getProperty("cancel"), c, new ExitWindowAction(this));
        addOkBtn(config.getProperty("ok"), c, new ChangeStateAction(gameWindow, "running"));

        centreWindow();
    }

    /**
     * Metoda dodająca etykietę wyboru pseudonimu
     * @param name Tutuł etykiety
     * @param constraints
     * @param action
     */
    private void addNickLabel(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        lNickTitle = new JLabel(name);
        //lNickTitle.setBounds(70,30,160,40);
        lNickTitle.setFont(new Font("SansSerif",Font.BOLD,16));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(lNickTitle, constraints);
    }

    /**
     * Metoda dodająca pole tekstowe
     * @param name Nazwa Inputa
     * @param constraints
     * @param action
     */
    private void addNickInput(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        tNickname = new JTextField("");
        //tNickname.setBounds(50,80,180,20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        add(tNickname, constraints);
    }

    /**
     * Metoda dodająca przycisk anuluj
     * @param name Tytuł przycisku
     * @param constraints
     * @param action
     */
    private void addCancelBtn(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        bCancel = new JButton(name);
        //bCancel.setBounds(150,130,80,20);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(bCancel, constraints);
        bCancel.addActionListener(action);
    }

    /**
     * Metoda dodająca przycisk ok
     * @param name Tytuł przycisku
     * @param constraints
     * @param action
     */
    private void addOkBtn(
            String name,
            GridBagConstraints constraints,
            ActionListener action
    ){
        bOk = new JButton(name);
        //bOk.setBounds(50,130,80,20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(bOk, constraints);
        bOk.addActionListener(new ExitWindowAction(this));
        bOk.addActionListener(action);
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
