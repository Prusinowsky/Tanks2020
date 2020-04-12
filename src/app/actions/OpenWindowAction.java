package app.actions;

import app.windows.WindowInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Akcja odpowiedzialna za okna okna, wstrzykniętego poprzez konstruktor
 */
public class OpenWindowAction implements ActionListener {

    /**
     * Zmienna przechowujaca okno
     */
    protected WindowInterface window;

    /**
     * Kontruktor tworzący nowy obiekt, wraz ze wstrzykniętą zależnością okna
     * @param window Zawierza przekazywane okno
     */
    public OpenWindowAction(WindowInterface window){
        this.window = window;
    }

    /**
     * Metoda wywoływana podczas wykonania wykonania pewnej akcji
     * odpowiada za zamknięcie okna.
     * @param e Zawiera zdarzenie akcji
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.open();
    }
}
