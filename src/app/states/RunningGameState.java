package app.states;

import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.GameRunningView;

public class RunningGameState implements StateInterface {

    private StateManagerInterface manager;

    private GameWindow game;
    private GameRunningView runningView;

    public RunningGameState(StateManagerInterface manager, GameWindow game){
        this.manager = manager;
        this.game = game;
    }

    @Override
    public void start() {
        runningView = new GameRunningView();
        runningView.addHudPauseActionListener(e -> System.out.println("Pause"));
        runningView.addHudExitActionListener(e -> System.out.println("Exit"));
        game.add(runningView);
        game.revalidate();
        game.repaint();
    }

    @Override
    public void end() {
        game.remove(runningView);
    }
}
