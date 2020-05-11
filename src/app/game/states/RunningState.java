package app.game.states;

import app.display.windows.EndGameWindow;
import app.engine.interfaces.EngineInterface;
import app.game.manager.GameStateManagerInterface;
import app.display.windows.GameWindow;
import app.display.views.GameRunningView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RunningState implements StateInterface {

    private GameStateManagerInterface manager;

    private EngineInterface engine;

    private GameWindow game;
    private EndGameWindow endGame;
    private GameRunningView runningView;


    public RunningState(GameStateManagerInterface manager, GameWindow game, EngineInterface engine){
        this.manager = manager;
        this.game = game;
        this.engine = engine;
    }

    @Override
    public void start() {
        runningView = new GameRunningView();

        runningView.addHudPauseActionListener(e -> {
            runningView.getGameHudComponent().hidePause();
            runningView.getGameHudComponent().showResume();
            engine.pauseGame();
        });
        runningView.addHudResumeActionListener(e -> {
            runningView.getGameHudComponent().showPause();
            runningView.getGameHudComponent().hideResume();
            engine.resumeGame();
        });
        runningView.addHudExitActionListener(e -> manager.changeStateTo("welcome"));
        runningView.addUpActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveUp();
            }
        });
        runningView.addWActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveUp();
            }
        });
        runningView.addDownActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveDown();
            }
        });
        runningView.addSActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveDown();
            }
        });
        runningView.addRightActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveRight();
            }
        });
        runningView.addDActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveRight();
            }
        });
        runningView.addLeftActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveLeft();
            }
        });
        runningView.addAActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().moveLeft();
            }
        });
        runningView.addSpaceActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().shoot();
            }
        });
        runningView.addEnterActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().shoot();
            }
        });
        runningView.addEActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.getDriver().shoot();
            }
        });

        engine.getRender().setGameScreenComponent(runningView.getGameScreenComponent());
        engine.getRender().setGameHudComponent(runningView.getGameHudComponent());

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
