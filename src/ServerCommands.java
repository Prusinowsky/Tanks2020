import java.io.IOException;
/**
 * Klasa odpwiedziana za wybor odpowiedzi serwera na zadanie klienta
 */
public class ServerCommands {
    /**
     * Na podstawie żądania klienta wybierana jest odpowiednia odpowiedź
     * @param command treść żądania klienta
     * @return odpowiedź serwera
     */
    public static String serverAction(String command) throws IOException {
        String serverMessage;
        String[] commands = command.split(" ");
        switch (commands[0]) {
            case "getAmountOfMaps":
                serverMessage = PropertiesLoader.giveAmountOfMap();
                break;
            case "getMapByIndex":
                serverMessage = PropertiesLoader.giveMap(Integer.parseInt(commands[1]));
                break;
            case "getMaps":
                serverMessage = PropertiesLoader.giveMapsDetails();
                break;
            case "getRanking":
                serverMessage = Ranking.getRanking();
                break;
            case "getRankingSize":
                serverMessage = Ranking.giveRankingSize();
                break;
            case "saveScore":
                Ranking.saveScore(commands[1],commands[2]);
                serverMessage = "Score saved";
                break;
            default:
                serverMessage = "Invalid command";
        }
        return serverMessage;
    }
}
