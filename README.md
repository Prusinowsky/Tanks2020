# **PROZE Tanki 2020 - Protokół Sieciowy**

### **Działanie serwera**

Serwer jest niezależną aplikacją. Po uruchomieniu serwer wyświetla adres IP przez który można się połączyć oraz numer portu na którym działa. Poza tym serwer odczytuje pliki konfiguracyjne i na żądanie klienta wysyła dane z tych plików. Również na żądanie klienta serwer zapisuje wynik końcowy, który otrzymał od tego klienta wraz z aktualizowaną listą wyników. Serwer może obsługiwać wiele klientów naraz lecz na obsługę każdego klienta przypada jeden wątek.

### **Działanie klienta**

Użytkownik uruchamiając klient ma do wyboru 2 opcje: działanie aplikacji z lokalnych plików bądź logowanie się przez podanie adresu hosta i numeru portu. Następnie klient wysyła żądanie do serwera aby otrzymać dane z plików konfiguracyjnych. Wraz z końcem gry klient wysyła żądanie serwerowi by zaktualizował listę wyników.

### **Podstawowe informacje o protokole**

Protokół jest typu tekstowego. Dane są przesyłane w jednej linii, a znak nowe linii `\n` informuje o końcu przesyłanych danych. 

### **Działanie protokołu**

Za każdym razem gdy klient chce wysłać żądanie do serwera następuje ustanowienie połączenia. Po otrzymaniu odpowiedzi na żądanie połączenie zostaje przerwane.

* Klient prosi serwer o wysłanie map

  ```
  C: getAmountOfMaps => S
  ```

  

* Serwer odpowiada wysyłając klientowi mapy

  ```
  S: giveAmountofMaps value(int) => C
  ```

  

* Klient wysyła serwerowi wynik uzyskany przez gracza (int) wraz z jego Nickiem (string)

  ```
  C: saveScore nick score => S
  ```

  

* Serwer odpowiada czy wynik został zapisany na liście (boolean) i na jakiej pozycji (int) (jeśli nie został zapisany domyślnie zwróci 0)

  ```
  S: score ifSaved id => C
  ```

  

* Klient prosi serwer o wysłanie wyniku na danej pozycji w rankingu

  ```
  C: getRanking id => S
  ```
  
* Klient prosi serwer o wysłanie o ilości zapisanych rankingów

  ```
  C: getRankingSize => S
  ```

  

* Serwer odpowiada klientowi wysyłając wynik (int) i nick gracza (string) na danej pozycji w rankingu.

  ```
  S: giveScore nick score => C
  ```

  

* Klient prosi serwer o definicje wyglądu mapy o zadanym numerze

  ```
  C: getMapByIndex mapIndex => S
  ```

  

* Serwer odpowiada wysyłając cztery linie tekstu(ciągi liczb odseparowane myślnikami na podstawie których program rysuje komponenty graficzne)

  ```
  S: giveMap => C
  amountOfLayers
  sizeX
  sizeY
  
  ...
  
  0000042000000000
  0040000400420040
  0440444400422400
  0002200004424000
  0440444440000000
  0042400004404440
  0042404400404000
  0440404000000400
  0000042204040442
  0004045244040402
  4444044400042400
  0204000044442400
  0024444000002200
  0040040044440440
  0400040040400400
  0000000000400000
  
  ...
  ```

  

  