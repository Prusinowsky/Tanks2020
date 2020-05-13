package app.config;

import java.io.*;
import java.util.Properties;

/**
 * Klasa odpowiedzialna za ładowanie konfiguracji
 */
public class Config implements ConfigInterface {

    /**
     * Zmienna zwierającą tylko jedną instancję obiektu konfiguracji
     * w całej aplikacji
     */
    private static Config _instance = null;

    /**
     * Obiekt zawierający wszystkie dane konfiguracyjne
     * klucz-wartość
     */
    private static Properties props;

    /**
     * Prywatny konstruktor blokujący tworzenie wielu nowych
     * konfiguracji - SINGLETON!
     *
     * SINGLETON jest antywzorcem projektowym, ale na potrzeby
     * tego projektu ułatwia dostęp do danych konfiguracyjnych.
     * Używając go mamy tego świadomość.
     */
    public Config(){

    }

    /**
     * Metoda odpowiedzialna za załadowanie danych konfiguracyjnych
     * z pliku.
     */
    public void load() {
        try {
            props = new Properties();
            props.loadFromXML(getClass().getResourceAsStream("/config/app.xml"));
            props.loadFromXML(getClass().getResourceAsStream("/config/game.xml"));
            props.loadFromXML(getClass().getResourceAsStream("/config/lang.xml"));

        } catch (FileNotFoundException e) {
            System.out.println(e);
            // Do sth please
        } catch (IOException e){
            System.out.println(e);
            // Do sth please
        }
    }

    /**
     * Metoda odpowiedzialna za zwracanie obiektu zawierającego
     * dane konfiguracyjne klucz-wartość
     * @return Properities
     */
    public Properties getProps(){
        return props;
    }

    /**
     * Metoda zwaraca wartość dla danego klucza
     * @param key Określa klucz dla jakiego ma zostać zwrócona wartość
     * @return String
     */
    public String getProperty(String key){
        return getProps().getProperty(key);
    }
}
