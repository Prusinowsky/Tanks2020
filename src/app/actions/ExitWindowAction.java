package app.actions;

import app.windows.interfaces.WindowInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Akcja odpowiedzialna za zamykanie okna, wstrzykniętego poprzez konstruktor
 */
public class ExitWindowAction implements ActionListener {

    /**
     * Zmienna przechowujaca okno
     */
    protected WindowInterface window;

    /**
     * Kontruktor tworzący nowy obiekt, wraz ze wstrzykniętą zależnością okna
     * @param window Zawiera przekazane okno
     */
    public ExitWindowAction(WindowInterface window){
        this.window = window;
    }

    /**
     * Metoda wywoływana podczas wykonania wykonania pewnej akcji
     * odpowiada za zamknięcie okna.
     * @param e Zawiera zdarzenie akcji
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.close();
    }

}
