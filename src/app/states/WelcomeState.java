package app.states;

import app.Container;
import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.SetNickWindow;
import app.windows.views.MenuStartView;

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
        menu.addStartActionListener(e-> {
            SetNickWindow nick = new SetNickWindow();
            nick.addSetNameActionListener(event -> {
                Container.getInstance().provideOptions().nickname = nick.getNickInput().getText();
            });
            nick.addCancelActionListener(event -> nick.dispose());
            nick.addOklActionListener(event -> {
                nick.dispose();
                Container.getInstance().provideOptions().nickname = nick.getNickInput().getText();
                manager.changeStateTo("running-game");
            });
        });
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
