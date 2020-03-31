package app.windows;

import app.actions.ExitWindowAction;
import app.actions.OpenWindowAction;
import app.windows.interfaces.WindowInterface;

import javax.swing.*;
import java.awt.event.*;


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
        setSize(800,800);
        setTitle("Moje okienko");
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("Gra");
        mStart = new JMenuItem("Start");
        mMap = new JMenuItem("Wybierz mapę");
        mScore = new JMenuItem("Najlepsze wyniki");
        mExit = new JMenuItem("Koniec");
        menuBar.add(menuFile);
        menuFile.add(mStart);
        menuFile.add(mMap);
        menuFile.add(mScore);
        menuFile.add(mExit);
        menuBar.add(Box.createHorizontalGlue());
        menuHelp = new JMenu("Pomoc");
        mAbout = new JMenuItem("O Programie");
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
