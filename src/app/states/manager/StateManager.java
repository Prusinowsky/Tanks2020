package app.states.manager;

import app.Container;
import app.engine.EngineInterface;
import app.states.*;
import app.windows.*;

import javax.swing.*;
import java.util.HashMap;

/**
 * Menadżer stanów
 */
public class StateManager implements StateManagerInterface {

    private GameWindow game;
    private Container container;
    private EngineInterface engine;

    private StateInterface current;
    private HashMap<String, StateInterface> states = new HashMap<String, StateInterface>();

    /**
     * Konstruktor domyslny
     * @param container
     */
    public StateManager(Container container, EngineInterface engine){
        this.container = container;
        this.engine = engine;
    }

    /**
     * Metoda uruchamiajaca menagera stanow
     */
    @Override
    public void execute() {
        init();
        initStates();
        current = states.get("welcome");
        current.start();
    }

    /**
     * Inicjalizacja okna glownego
     */
    private void init(){
        game = new GameWindow();
        game.addMenuStartActionListener(e -> {
            SetNickWindow nick = new SetNickWindow();
            nick.addSetNameActionListener(event -> {
                Container.getInstance().provideOptions().nickName = nick.getNickInput().getText();
            });
            nick.addCancelActionListener(event -> nick.dispose());
            nick.addOklActionListener(event -> {
                nick.dispose();
                Container.getInstance().provideOptions().nickName = nick.getNickInput().getText();
                changeStateTo("running-game");
            });
        });
        game.addMenuMapChooseActionListener(e -> {
            ChooseMapWindow map = new ChooseMapWindow();
            map.addChooseMapActionListener(event -> {
                Container.getInstance().provideOptions().mapName = (String) ((JComboBox)event.getSource()).getSelectedItem();
            });
            map.addCancelActionListener(event -> map.dispose());
            map.addOkActionListener(event -> map.dispose());
        });
        game.addMenuScoreActionListener(e -> {
            ScoreWindow score = new ScoreWindow();
            score.addOkActionListener(event -> score.dispose());
        });
        game.addMenuAboutActionListener(e -> {
            HelpWindow about = new HelpWindow();
            about.addOkActionListener(event -> about.dispose());
        });
        game.addMenuExitActionListener(e -> exit());

    }

    /**
     * Inicjalizacja stanów
     */
    private void initStates(){
        states.put("welcome", new WelcomeState(this, game));
        states.put("running-game", new RunningGameState(this, game, engine));
    }

    @Override
    public void changeStateTo(String toState) {
        current.end();
        current = states.get(toState);
        current.start();
    }

    /**
     * Metoda konczaca działanie mendadżera stanów
     */
    @Override
    public void exit() {
        current.end();
        states.clear();
        System.exit(0);
    }

}
