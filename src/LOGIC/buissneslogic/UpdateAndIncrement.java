package LOGIC.buissneslogic;

import MODEL.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class UpdateAndIncrement {

    // mögliche Aktionen für Torhüter
    private static final Set<String> TORHUETER_AKTIONEN = Set.of("hitByKeeper", "missByKeeper", "saveNine", "saveSeven", "saveSix",
            "saveWing", "saveBreakthrough", "saveCounterattack", "concededNine", "concededSeven", "concededSix",
            "concededWing", "concededBreakthrough", "concededCounterattack");

    // mögliche Aktionen für Feldspieler
    private static final Set<String> FELDSPIELER_AKTIONEN = Set.of("goalNine", "goalSeven", "goalSix", "goalWing", "goalBreakthrough", "goalCounterattack",
            "missedNine", "missedSeven", "missedSix", "missedWing", "missedBreakthrough", "missedCounterattack");

    // mögliche Aktionen für alle Spieler
    private static final Set<String> SPIELER_AKTIONEN = Set.of("lossOfBall", "ballWin", "assist", "fetchedSevenM", "causedSevenM",
            "fetchedTwoMinutes", "yellowCard", "twoMinutes", "redCard", "technicalMistake", "passCatchMistake");

    /**
     * Aktualisiert die Statistik eines Spielers basierend auf der durchgeführten Aktion.
     *
     * @param player die zu aktualisierende Spielerinstanz
     * @param action der Name der durchgeführten Aktion
     * @throws IllegalArgumentException wenn die übergebene Aktion nicht bekannt ist
     */
    public static void updatePlayerStats(Player player, String action) {
        if (TORHUETER_AKTIONEN.contains(action) || FELDSPIELER_AKTIONEN.contains(action) || SPIELER_AKTIONEN.contains(action)) {
            incrementPlayerStat(player, action);
            System.out.println(player.getGoalSix());
        } else {
            throw new IllegalArgumentException("Unbekannte Aktion: " + action);
        }
    }

    /**
     * Eine Hilfsklasse, die die Spielerstatistik aktualisiert, indem die entsprechende Methode des Spielers aufgerufen wird,
     * die die Anzahl der Ausführungen der übergebenen Aktion erhöht.
     * Wenn die Methode nicht gefunden oder aufgerufen werden kann, wird eine RuntimeException ausgelöst.
     */
    private static void incrementPlayerStat(Player player, String action) {
        // Generiere den Namen der Getter-Methode anhand der Aktion
        String methodName = "get" + action.substring(0, 1).toUpperCase() + action.substring(1);
        Method getter;
        try {
            // Hole die Getter-Methode aus der Player-Klasse
            getter = player.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            // Falls die Methode nicht existiert, wirf eine RuntimeException mit entsprechendem Fehlermeldungstext
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        int currentValue;
        try {
            // Rufe die Getter-Methode auf, um den aktuellen Wert der Statistik zu erhalten
            currentValue = (int) getter.invoke(player);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // Falls es Probleme mit der Methoden-Reflexion gibt, wirf eine RuntimeException mit entsprechendem Fehlermeldungstext
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        // Generiere den Namen der Setter-Methode anhand der Aktion
        String setterName = "set" + action.substring(0, 1).toUpperCase() + action.substring(1);
        Method setter;
        try {
            // Hole die Setter-Methode aus der Player-Klasse
            setter = player.getClass().getMethod(setterName, int.class);
        } catch (NoSuchMethodException e) {
            // Falls die Methode nicht existiert, wirf eine RuntimeException mit entsprechendem Fehlermeldungstext
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        try {
            // Rufe die Setter-Methode auf und übergebe den inkrementierten Wert der Statistik
            setter.invoke(player, currentValue + 1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // Falls es Probleme mit der Methoden-Reflexion gibt, wirf eine RuntimeException mit entsprechendem Fehlermeldungstext
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }
    }
}
