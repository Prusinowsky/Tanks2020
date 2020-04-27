package app.states;

import app.engine.interfaces.EngineInterface;
import app.states.manager.StateManagerInterface;
import app.windows.GameWindow;
import app.windows.views.GameRunningView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println("up");
            }
        });
        runningView.addDownActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveDown();
                System.out.println("down");
            }
        });
        runningView.addRightActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveRight();
                System.out.println("right");
            }
        });
        runningView.addLeftActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.moveLeft();
                System.out.println("left");
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
