package app.main;

import app.config.Config;
import app.windows.MainWindow;

public class Main {

    public static void main(String[] args)
    {
        Config config = Config.getInstance();
        config.load();
        MainWindow app = new MainWindow();
        app.open();
    }

}
