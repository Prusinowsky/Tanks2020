package app.windows.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuStartComponent extends JComponent {

    public MenuStartComponent(){
        super();
        setLayout(new GridBagLayout());

        render();
    }

    private void render(){

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;

        JLabel welcome = new JLabel();
        welcome.setText("TANKS 2020");
        c.gridx = 0;
        c.gridy = 0;
        add(welcome, c);

        JButton start = new JButton("Start");
        c.gridx = 0;
        c.gridy = 1;
        add(start, c);

        JButton exit = new JButton("Wyjdź z gry");
        c.gridx = 0;
        c.gridy = 2;
        add(exit, c);

    }
}
