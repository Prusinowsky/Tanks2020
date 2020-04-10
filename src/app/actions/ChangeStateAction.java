package app.actions;

import app.windows.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeStateAction implements ActionListener {

    private GameWindow gameWindow;
    private String stateName;

    public ChangeStateAction(GameWindow gameWindow, String stateName){
        this.gameWindow = gameWindow;
        this.stateName = stateName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.changeState(stateName);
    }
}
