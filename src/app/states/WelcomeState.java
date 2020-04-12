package app.states;

import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.MenuStartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Stan początku gry
 */
public class WelcomeState implements StateInterface {

    private StateManagerInterface manager;
    private GameWindow game;
    private MenuStartView menu;

    public WelcomeState(StateManagerInterface manager, GameWindow game){
        this.manager = manager;
        this.game = game;
    }

    @Override
    public void start() {
        menu = new MenuStartView();
        menu.addStartActionListener(e -> manager.changeStateTo("running-game"));
        menu.addExitActionListener(e -> manager.exit());
        game.add(menu);
        game.revalidate();
        game.repaint();
    }

    @Override
    public void end() {
        game.remove(menu);
    }
}
