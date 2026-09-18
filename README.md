# Gæt et tal – Feedbackopgave 3

Dette er et konsolbaseret "Gæt et tal"-spil skrevet i Java. Spillet udfordrer brugeren til at gætte et tilfældigt genereret tal inden for tre forskellige sværhedsgrader. Spillet holder styr på dine highscores (færrest brugte forsøg) på tværs af runderne.

## 🎮 Funktioner

- **Tre sværhedsgrader:** Vælg mellem Let, Mellem og Svær med forskellige talområder og liv.
- **Highscore-system (Stats):** Spillet gemmer din bedste score (færrest forsøg) for hver sværhedsgrad i den aktive spilsession.
- **Ubegrænsede runder:** Efter hver runde kan du vælge at spille igen eller afslutte og se din endelige statistik.

## 🛠️ Sværhedsgrader

| Sværhedsgrad | Talområde | Antal liv / forsøg |
| :--- | :--- | :--- |
| **1. LET** | 1 - 10 | Ubegrænset |
| **2. MELLEM** | 1 - 50 | 10 liv |
| **3. SVÆR** | 1 - 100 | 7 liv |

## 🚀 Kom i gang

### Forudsætninger
For at køre spillet skal du have **Java Development Kit (JDK)** installeret på din computer.

### Kørsel af spillet
1. Klon dette repository eller download `Main.java`.
2. Åbn din terminal/kommandoprompt i den mappe, hvor filen ligger.
3. Kompiler Java-filen med følgende kommando:
   ```bash
   javac Main.java
   ```
4. Kør spillet:
   ```bash
   java Main
   ```

## 🕹️ Sådan spiller du

1. Når spillet starter, bliver du mødt af en menu.
2. Indtast et tal fra **1-3** for at vælge sværhedsgrad, **4** for at se dine nuværende stats, eller **5** for at slukke spillet.
3. Gæt tallet ud fra de ledetråde, spillet giver dig (*"Du er for høj"* eller *"Du er for lav"*).
4. Efter runden spørger spillet, om du vil spille igen (`ja`/`nej`). (ALT andet end nej vil blive betragtet som ja😊)

## 📁 Kode-struktur

Spillet er samlet i én fil (`Main.java`) og gør brug af følgende metoder:
- `main()`: Styring af spillets overordnede spilloop.
- `showMenu()`: Viser hovedmenuen i konsollen.
- `chooseDifficulty()`: Håndterer brugervalg af sværhedsgrad og liv.
- `generateNumber()`: Genererer det tilfældige tal baseret på sværhedsgraden.
- `playGame()`: Selve spilmekanikken, hvor brugeren gætter, og der gives feedback.
- `calculateEasyBS / calculateMediumBS / calculateHardBS`: Beregner og opdaterer highscores.  -BS BestScore
- `printStats()`: Viser dine highscores (findes som overloaded metode til hhv. menuen og afslutning).
