package com.game;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MainFrame extends JFrame implements ActionListener
{
    private JMenu menuFile, menuHelp;
    private JMenuItem mStart, mMap, mScore, mExit, mAbout;
    private JMenuBar menuBar;

    ScoreFrame scoreFrame = new ScoreFrame();
    MapFrame mapFrame = new MapFrame();
    HelpFrame helpFrame = new HelpFrame();
    NickFrame nickFrame = new NickFrame();

    public MainFrame()
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
        mStart.addActionListener(this);
        mMap.addActionListener(this);
        mScore.addActionListener(this);
        mExit.addActionListener(this);

        menuBar.add(Box.createHorizontalGlue());
        menuHelp = new JMenu("Pomoc");
        mAbout = new JMenuItem("O Programie");
        menuBar.add(menuHelp);
        menuHelp.add(mAbout);
        mAbout.addActionListener(this);
    }

    public void run()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void close()
    {
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source==mStart)
        {
            nickFrame.run();
        }
        else if(source==mMap)
        {
            mapFrame.run();
        }
        else if(source==mScore)
        {
            scoreFrame.run();
        }
        else if(source==mExit)
        {
            close();
        }
        else if(source==mAbout)
        {
            helpFrame.run();
        }
    }
}
