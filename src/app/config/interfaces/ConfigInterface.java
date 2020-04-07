package app.config.interfaces;

import java.util.Properties;

/**
 * Interfejs konfiguracji umożliwiający stworzenie
 * własnego obiektu odpowiedzialenego za obsługę
 * plików konfiguracyjnych
 */
public interface ConfigInterface {


    /**
     * Metoda odpowiadająca za zwracanie tylko jednej instacji konfiguracji w pliku
     * @return
     */
    public ConfigInterface getInstance();

    /**
     * Metoda odpowiedzialna za ładowanie pilku zawierającego
     * dane konfiguracyjnego
     */
    public void load();

    /**
     * Metoda odpowiedzialna za zwracanie danej wartości konfiguracyjnej
     * @return Properties Zwraca obiekt zawierający daną konfiguracyjną klucz-wartość
     */
    public Properties getProps();
}
