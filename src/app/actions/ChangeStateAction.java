package app.actions;

import app.windows.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeStateAction implements ActionListener {

    private GameWindow gameWindow;
    private String toState;

    public ChangeStateAction(GameWindow gameWindow, String toState){
        this.gameWindow = gameWindow;
        this.toState = toState;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.changeState(toState);
    }
}
