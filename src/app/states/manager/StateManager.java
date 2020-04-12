package app.states.manager;

import app.Container;
import app.states.*;
import app.windows.ChooseMapWindow;
import app.windows.GameWindow;
import app.windows.HelpWindow;
import app.windows.ScoreWindow;

import javax.swing.*;
import java.util.HashMap;

/**
 * Menadżer stanów
 */
public class StateManager implements StateManagerInterface {

    private GameWindow game;

    private Container container;

    private StateInterface current;
    private HashMap<String, StateInterface> states = new HashMap<String, StateInterface>();

    /**
     * Konstruktor domyslny
     * @param container
     */
    public StateManager(Container container){
        this.container = container;
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
        game.addMenuStartActionListener(e -> changeStateTo("running-game"));
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
        states.put("new-game", new NewGameState());
        states.put("running-game", new RunningGameState(this, game));
        states.put("pause-game", new PauseGameState());
        states.put("end-game", new PauseGameState());
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
