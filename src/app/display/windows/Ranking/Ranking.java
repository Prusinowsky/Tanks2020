package app.display.windows.Ranking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;

public class Ranking {
    static ArrayList<String> ranking;

    static String getScore(int index){
        return ranking.get(index).split("-")[0] + ": " + ranking.get(index).split("-")[1];
    }

    static void SaveInFile() throws IOException {
        InputStream propertiesFile = new FileInputStream("/config/Ranking.txt");
        Properties properties = new Properties();
        properties.load(propertiesFile);
        for(int i=0;i<5;i++) {
            properties.setProperty("nick" + (i+1), ranking.get(i).split("-")[0]);
            properties.setProperty("score" + (i+1), ranking.get(i).split("-")[1]);
        }
        properties.store(new FileOutputStream("/config/Ranking.txt"), null);
        propertiesFile.close();
    }

    public static void loadRanking() throws IOException {
        InputStream propertiesFile = new FileInputStream("/config/Ranking.txt");
        Properties properties = new Properties();
        properties.load(propertiesFile);
        ranking = new ArrayList<>();
        for(int i = 1 ; i <= 5 ; i++){
            ranking.add(properties.getProperty("nick"+i)+"-"+properties.getProperty("score"+i));
        }
        propertiesFile.close();
        ranking.sort(new MyComparator());
    }

    static void SaveScore(int score, String nick) throws IOException {
        ranking.add(nick + "-" + score);
        ranking.sort(new MyComparator());
        ranking.remove(ranking.size()-1);
        SaveInFile();
    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2){
            Integer a = Integer.parseInt(o1.split("-")[1]);
            Integer b = Integer.parseInt(o2.split("-")[1]);
            return -a.compareTo(b);
        }
    }
}
