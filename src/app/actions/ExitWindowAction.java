package app.actions;

import app.windows.interfaces.WindowInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitWindowAction implements ActionListener {

    protected WindowInterface window;

    public ExitWindowAction(WindowInterface window){
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.close();
    }

}
