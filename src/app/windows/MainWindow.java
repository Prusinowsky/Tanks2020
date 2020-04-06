package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Główne okno aplikacji - STARTOWE (MENU)
 */
public class MainWindow extends JFrame implements WindowInterface
{
    private JMenu menuFile, menuHelp;
    private JMenuItem mStart, mMap, mScore, mExit, mAbout;
    private JMenuBar menuBar;

    ScoreWindow scoreFrame = new ScoreWindow();
    MapWindow mapFrame = new MapWindow();
    HelpWindow helpFrame = new HelpWindow();
    NickWindow nickFrame = new NickWindow();

    /**
     * Kontruktor inicjalizujący główne okno apliakcji
     */
    public MainWindow()
    {
        Config config = Config.getInstance();

        setSize(800,800);
        setTitle(config.getProperty("title"));
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu(config.getProperty("game"));
        mStart = new JMenuItem(config.getProperty("start"));
        mMap = new JMenuItem(config.getProperty("choose_map"));
        mScore = new JMenuItem(config.getProperty("best_scores"));
        mExit = new JMenuItem(config.getProperty("exit"));
        menuBar.add(menuFile);
        menuFile.add(mStart);
        menuFile.add(mMap);
        menuFile.add(mScore);
        menuFile.add(mExit);
        menuBar.add(Box.createHorizontalGlue());
        menuHelp = new JMenu(config.getProperty("help"));
        mAbout = new JMenuItem(config.getProperty("about"));
        menuBar.add(menuHelp);
        menuHelp.add(mAbout);

        mStart.addActionListener(new OpenWindowAction(nickFrame));
        mMap.addActionListener(new OpenWindowAction(mapFrame));
        mScore.addActionListener(new OpenWindowAction(scoreFrame));
        mAbout.addActionListener(new OpenWindowAction(helpFrame));
        mExit.addActionListener(new ExitWindowAction(this));

        centreWindow(this);
    }

    /**
     * Metoda centrująca położenie okna
     * @param frame Zawiera przekazane okno
     */
    public static void centreWindow(MainWindow frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    /**
     * Metoda implementująca otwarcie okna
     */
    public void open()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Metoda implementująca zamknięcie okna
     */
    public void close()
    {
        dispose();
    }

}
