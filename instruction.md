# **PROZE Tanki 2020 – Instrukcja**

### **Podstawowe informacje**

Celem gry jest zdobycie jak największą ilość punktów, poruszając się czołgiem po mapie szukając portalu, który przeniesie gracz do kolejnego poziomu. Przed rozpoczęciem rozgrywki gracz podaje swój pseudonim, a wraz z końcem gry podawany jest jego wynik. Gra może działać w trybie lokalnym jak i sieciowym. Gra działa na systemach Windows oraz Linux, działanie wymaga Java Runtime Environment.

### **Uruchomienie gry**

Grę uruchamiamy poprzez plik `Tanks2020.jar`

`TODO:  `

`1. Dodać kompilator do kompilacji gry `

`2. Stworzyć piliku uruchomieniowe .sh oraz .bat `

`3. Stowrzyć plik .jar`

### **Zasady i przebieg gry**

Gracz porusza się czołgiem po mapie. Jego celem jest przechodzenie poziomów i zbieranie punktów. W tym wszystkim przeszkadzają mu czołgi wrogów (botów) oraz przeszkody. Wrogów można wyeliminować poprzez zestrzelenie. Są bloki zniszczalne i odporne na strzał gracza. Poziom kończy się gdy gracz dojdzie do portalu, który go przeniesie do kolejnego poziomu. Wrogowie mają zdolności niszczenia bloków. W momencie gdy gracz będzie w polu widoczności wroga zaczyna on podążać i strzelać w stronę gracza. Po przejściu wszystkich poziomów gra się zapętla i gracz zaczynana od początku dalej zwiększając wynik. Gracz ograniczają domyślnie 3 życia. Z każdą śmiercią stan poziomu jest resetowany to znaczy wszystkie zniszczone bloki oraz przeciwnicy wracają do stanu początkowego.

### **Punktacja**

Gracz za zniszczenie czołgu wroga dostaje 50 punktów, natomiast za zniszczenie bloków jest karany utratą 10 punktów. Przejście poziomu jest nagradzane ilością żyć pomnożoną przez 100.

`TODO: Napisać wzór`

### **Sterowanie**

Gracz steruje czołgiem za pomocą strzałek bądź `WASD`’u. Klawisz określa kierunek poruszania się, to znaczy strzałka w górę bądź `W`, powoduje poruszenie się do góry i analogicznie z pozostałymi klawiszami. Strzał jest wykonywany za pomocą `spacji`, `entera` bądź `E`. Przytrzymując klawisze poruszania się gracz porusza się płynnie, a przytrzymując klawisze strzelania wykonuje serię strzałów.