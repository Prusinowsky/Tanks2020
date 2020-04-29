package app.game.states;

import app.Container;
import app.game.manager.GameStateManagerInterface;
import app.display.windows.GameWindow;
import app.display.windows.SetNickWindow;
import app.display.views.MenuStartView;

/**
 * Stan początku gry
 */
public class WelcomeState implements StateInterface {

    private GameStateManagerInterface manager;
    private GameWindow game;
    private MenuStartView menu;

    public WelcomeState(GameStateManagerInterface manager, GameWindow game){
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
