package app.windows.views;

import app.Container;
import app.config.ConfigInterface;
import app.engine.Engine;
import app.engine.interfaces.Renderable;
import app.windows.components.GameHudComponent;
import app.windows.components.GameScreenComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Komponent odpowiadajacy za renderowanie gry
 */
public class GameRunningView extends JComponent {

    private ConfigInterface config;

    private GameScreenComponent view;
    private GameHudComponent hud;

    /**
     * Konstruktor Domyslny
     */
    public GameRunningView(){
        super();
        this.config = Container.getInstance().provideConfig();

        setSize(new Dimension(500,700));
        setLayout(null);
        setVisible(true);

        init();
        handleResizing();
        render();

    }

    /**
     * Obsluga zmiany rozdzielczości okna
     */
    public void handleResizing(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                render();
            }
        });
    }

    public void init(){
        view = new GameScreenComponent();
        add(view);

        hud = new GameHudComponent(config);
        add(hud);
    }

    public GameScreenComponent getGameScreenComponent(){
        return view;
    }

    public GameHudComponent getGameHudComponent(){
        return hud;
    }

    /**
     * Renderowanie okna
     */
    public void render(){

        view.setBounds(0,0,(int)(getWidth()*0.8),getHeight());
        view.setSize(new Dimension((int)(getWidth()*0.8),getHeight()));

        hud.setBounds((int)(getWidth()*0.8),(int)(getHeight()*0.05),(int)(getWidth()*0.2), getHeight());
        hud.setSize(new Dimension((int)(getWidth()*0.18), (int)(getHeight()*0.9)));
        hud.render();

        repaint();
    }

    private class MoveAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("despacito");
           // if(this.direction=="down")
        }
    }

    public void addHudPauseActionListener(ActionListener action){
        hud.addPauseActionListener(action);
    }

    public void addHudExitActionListener(ActionListener action){
        hud.addExitActionListener(action);
    }

    public void addUpActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "move up");
        this.getActionMap().put("move up", action);
    }

    public void addWActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "move up");
        this.getActionMap().put("move up", action);
    }

    public void addDownActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "move down");
        this.getActionMap().put("move down", action);
    }

    public void addSActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "move down");
        this.getActionMap().put("move down", action);
    }

    public void addRightActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "move right");
        this.getActionMap().put("move right", action);
    }

    public void addDActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "move right");
        this.getActionMap().put("move right", action);
    }

    public void addLeftActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "move left");
        this.getActionMap().put("move left", action);
    }

    public void addAActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "move left");
        this.getActionMap().put("move left", action);
    }

    public void addSpaceActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "push space");
        this.getActionMap().put("push space", action);
    }

    public void addEnterActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "push enter");
        this.getActionMap().put("push enter", action);
    }

    public void addEActionListener(AbstractAction action) {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("E"), "push E");
        this.getActionMap().put("push E", action);
    }

}
