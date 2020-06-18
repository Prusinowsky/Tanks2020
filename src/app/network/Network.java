package app.network;

import app.Container;

import java.io.*;
import java.net.Socket;
import java.util.stream.Collectors;

/**
 * Klasa osbługująca sieć
 */
public class Network {

    private static Network _instace = null;
    static Socket socket;

    private Network(){};

    public static Network getInstance(){
        return _instace == null ? (_instace = new Network()) : _instace;
    }

    /**
     * Ustanawia polaczenie z serwerem. Tworzy obiekt klasy socket i wysyla zadanie do serwera
     * @param command Tresc zadania
     * @return linia tekstu bddaca odpowiedzia serwera
     */
    public static String connect(String command) throws IOException {
        String ipAddress = Container.getInstance().provideConfig().getProperty("ip_address");
        String port = Container.getInstance().provideConfig().getProperty("port");
        System.out.println(ipAddress + " " + port);
        try {
            socket = new Socket(ipAddress, Integer.parseInt(port));
        } catch (Exception e){
            System.out.println("Serwer offline");
        }
        socket = new Socket(ipAddress, Integer.parseInt(port));
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println(command);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.lines().map(String::new).map((String s) -> s + '\n').collect(Collectors.joining());
    }

    /**
     * Zapisuje wyniku na serwerze, w tym celu wywoluje metode connect z odpowiednim zapytaniem
     * @param nick nick gracza wraz z wynikiem odzielone znakiem "-"
     */
    public void saveScore(String nick, int score) throws IOException {
        connect("saveScore" + " " + nick + " " + score);
        socket.close();
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public String getAmountOfMaps() throws IOException {
        String respond = connect("getAmountOfMaps");
        socket.close();
        return respond;
    }

    /**
     * Wysyla do serwera zadanie o wyslanie danych konfiguracyjnych poziomu o zadanym indeksie, w tym celu wywoluje metode connect z odpowiednim zapytaniem
     * @param mapIndex numer poziomu ktory chcemmy uzyskac
     * @return linia tekstu będąca odpowiedzia od serwera
     */
    public String getMap(int mapIndex) throws IOException {
        String respond = connect("getMap" + " " + mapIndex);
        socket.close();
        return respond;
    }

    /**
     * Zwraca wielkość rankingu
     * @return
     * @throws IOException
     */
    public String getRankingSize() throws IOException {
        String respond = connect("getRankingSize");
        socket.close();
        return respond;
    }

    /**
     * Pozyskuje liste najlepszych wynikow z serwera, w tym celu wywoluje metode connect z odpowiednim zapytaniem
     * @return linia tekstu zawierajaca kolejne nazwy graczy wraz z wynikami
     */
    public String getRanking() throws IOException {
        String respond = connect("getRanking");
        socket.close();
        return respond;
    }

}
