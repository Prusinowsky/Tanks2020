package app.states;

import app.engine.EngineInterface;
import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.GameRunningView;

public class RunningGameState implements StateInterface {

    private StateManagerInterface manager;

    private GameWindow game;
    private GameRunningView runningView;
    private EngineInterface engine;

    public RunningGameState(StateManagerInterface manager, GameWindow game, EngineInterface engine){
        this.manager = manager;
        this.game = game;
        this.engine = engine;
    }

    @Override
    public void start() {
        engine.startGame();
        runningView = new GameRunningView(engine.getImageScreen());
        runningView.addHudPauseActionListener(e -> System.out.println("Michal zrobisz to co nie? :D"));
        runningView.addHudExitActionListener(e -> manager.changeStateTo("welcome"));
        game.add(runningView);
        game.revalidate();
        game.repaint();
    }

    @Override
    public void end() {
        game.remove(runningView);
    }
}
