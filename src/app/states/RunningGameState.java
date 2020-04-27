package app.states;

import app.engine.interfaces.EngineInterface;
import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.GameRunningView;

public class RunningGameState implements StateInterface {

    private StateManagerInterface manager;

    private EngineInterface engine;

    private GameWindow game;
    private GameRunningView runningView;


    public RunningGameState(StateManagerInterface manager, GameWindow game, EngineInterface engine){
        this.manager = manager;
        this.game = game;
        this.engine = engine;
    }

    @Override
    public void start() {
        runningView = new GameRunningView();
        runningView.addHudPauseActionListener(e -> System.out.println("Michal zrobisz to co nie? :D"));
        runningView.addHudExitActionListener(e -> manager.changeStateTo("welcome"));

        engine.setGameScreenComponent(runningView.getGameScreenComponent());
        engine.setGameHudComponent(runningView.getGameHudComponent());
        engine.startGame();

        game.add(runningView);
        game.revalidate();
        game.repaint();
    }

    @Override
    public void end() {
        game.remove(runningView);
        engine.endGame();
    }
}
