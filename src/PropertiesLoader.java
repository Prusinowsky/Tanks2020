
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

/**
 * Klasa odpowiedzialna za wczytywanie plikow konfiguracyjnych
 */
public class PropertiesLoader {
    public static String ipAddress;
    static int port;
    /**
     * Odczytuje z pliku konfiguracyjnego numer portu
     */
    static void loadPort() throws IOException {
        InputStream propertiesFile = new FileInputStream("config/network.xml");
        Properties properties = new Properties();
        properties.loadFromXML(propertiesFile);
        port = Integer.parseInt(properties.getProperty("port"));
    }
    /**
     * Odczytuje z pliku konfiguracyjnego min. wymiary okna, ilosc poziomow i pakuje je do jednej lini tekstu. Wszystkie parametry
     * odseparowane są myslnikiem
     * @return linia tekstu która zawiera wszystkie dane konfiguracyjne
     */
    static String giveAmountOfMap() throws IOException {
        InputStream propertiesFile = new FileInputStream("config/game.xml");
        Properties properties = new Properties();
        properties.loadFromXML(propertiesFile);
        String response = String.valueOf(properties.getProperty("map_numbers"));
        return response;
    }
    /**
     * Na zadanie klienta wysyła dane konfiguracyjne wybranego poziomu
     * @param mapIndex numer poziomu który chcemy uzyskać
     * @return linia tekstu na podstawie której klient jest w stanie odczytać wygląd planszy
     */
    static String giveMap(Integer mapIndex) throws IOException {
        String map = "";
        InputStream propertiesFile = new FileInputStream("config/game.xml");
        Properties properties = new Properties();
        properties.loadFromXML(propertiesFile);
        for(Integer i=0; i<mapIndex; i++){
            map = properties.getProperty("map_path_" + mapIndex);
        }
        Scanner scanner = new Scanner(new File("assets/maps/" + map));
        Integer amountOfLayers = Integer.parseInt(scanner.nextLine());
        Integer sizeX = Integer.parseInt(scanner.nextLine());
        Integer sizeY = Integer.parseInt(scanner.nextLine());
        String layers = "";
        for(Integer i=0; i<amountOfLayers; i++){
            scanner.nextLine();
            layers += "\n";
            for(Integer j=0; j<sizeY; j++){
                layers += scanner.nextLine();
                layers += "\n";
            }
        }
        return (Integer.toString(amountOfLayers) + "\n" + Integer.toString(sizeX) + "\n" + Integer.toString(sizeY) + "\n" + layers);
    }

    /*static String giveMapsDetails(){

    }*/
}
