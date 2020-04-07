package app.config;

import app.config.interfaces.ConfigInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private Config(){

    }

    /**
     * Metoda zwracająca instancję obiektu Konfiguracyjnego,
     * jeżeli taki nie istnieje, to metoda go stworzy.
     * @return Config Zwraca obiekt Konifguracyjny
     */
    public static ConfigInterface getInstance(){
        if(_instance == null)
            _instance = new Config();
        return _instance;
    }

    /**
     * Metoda odpowiedzialna za załadowanie danych konfiguracyjnych
     * z pliku.
     */
    public void load() {
        try {
            FileReader reader = new FileReader("config/config.properties");
            props = new Properties();
            props.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            // Do sth please
        } catch (IOException e){
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
