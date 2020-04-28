package app.states;

import app.engine.interfaces.EngineInterface;
import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.GameRunningView;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        runningView.addUpActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveUp();
            }
        });
        runningView.addDownActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveDown();
            }
        });
        runningView.addRightActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveRight();
            }
        });
        runningView.addLeftActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveLeft();
            }
        });
        runningView.addSpaceActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.shoot();
            }
        });
        runningView.addEnterActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.shoot();
            }
        });

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
