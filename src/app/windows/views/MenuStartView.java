package app.windows.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuStartView extends JComponent {

    private JButton bStart, bExit;

    public MenuStartView(){
        super();
        setLayout(new GridBagLayout());
        init();
    }

    /**
     * Metoda odpowiadająca za inicjalizację stanu
     */
    private void init(){

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;

        JLabel welcome = new JLabel();
        welcome.setText("TANKS 2020");
        c.gridx = 0;
        c.gridy = 0;
        add(welcome, c);

        bStart = new JButton("Start");
        c.gridx = 0;
        c.gridy = 1;
        add(bStart, c);

        bExit = new JButton("Wyjdź z gry");
        c.gridx = 0;
        c.gridy = 2;
        add(bExit, c);
    }

    public void addStartActionListener(ActionListener action){
        bStart.addActionListener(action);
    }

    public void addExitActionListener(ActionListener action){
        bExit.addActionListener(action);
    }
}
