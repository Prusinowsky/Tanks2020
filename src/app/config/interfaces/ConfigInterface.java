package app.config.interfaces;

import java.util.Properties;

/**
 * Interfejs konfiguracji umożliwiający stworzenie
 * własnego obiektu odpowiedzialenego za obsługę
 * plików konfiguracyjnych
 */
public interface ConfigInterface {

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
