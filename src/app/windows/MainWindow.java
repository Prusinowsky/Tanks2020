package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.config.Config;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;


public class MainWindow extends JFrame implements WindowInterface
{
    private JMenu menuFile, menuHelp;
    private JMenuItem mStart, mMap, mScore, mExit, mAbout;
    private JMenuBar menuBar;

    ScoreWindow scoreFrame = new ScoreWindow();
    MapWindow mapFrame = new MapWindow();
    HelpWindow helpFrame = new HelpWindow();
    NickWindow nickFrame = new NickWindow();

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
    }

    public void open()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void close()
    {
        dispose();
    }

}
