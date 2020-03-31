package app.actions;

import app.windows.interfaces.WindowInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenWindowAction implements ActionListener {

    protected WindowInterface window;

    public OpenWindowAction(WindowInterface window){
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.open();
    }
}
