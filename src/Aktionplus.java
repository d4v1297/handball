import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Aktionplus {
    private static final Set<String> TORHUETER_AKTIONEN = Set.of("hitByKeeper", "missByKeeper", "saveNine", "saveSeven", "saveSix",
            "saveWing", "saveBreakthrough", "saveCounterattack", "concededNine", "concededSeven", "concededSix",
            "concededWing", "concededBreakthrough", "concededCounterattack");

    private static final Set<String> FELDSPIELER_AKTIONEN = Set.of("goalNine", "goalSeven", "goalSix", "goalWing", "goalBreakthrough", "goalCounterattack",
            "missedNine", "missedSeven", "missedSix", "missedWing", "missedBreakthrough", "missedCounterattack");

    private static final Set<String> SPIELER_AKTIONEN = Set.of("lossOfBall", "ballWin", "assist", "fetchedSevenM", "causedSevenM",
            "fetchedTwoMinutes", "yellowCard", "twoMinutes", "redCard", "technicalMistake", "passCatchMistake");

    static void updatePlayerStats(Player player, String action) {
        if (TORHUETER_AKTIONEN.contains(action) || FELDSPIELER_AKTIONEN.contains(action) || SPIELER_AKTIONEN.contains(action)) {
            incrementPlayerStat(player, action);
            System.out.println(player.getGoalSix());
        } else {
            throw new IllegalArgumentException("Unbekannte Aktion: " + action);
        }
    }

    private static void incrementPlayerStat(Player player, String action) {
        String methodName = "get" + action.substring(0, 1).toUpperCase() + action.substring(1);
        Method getter;
        try {
            getter = player.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        int currentValue;
        try {
            currentValue = (int) getter.invoke(player);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        String setterName = "set" + action.substring(0, 1).toUpperCase() + action.substring(1);
        Method setter;
        try {
            setter = player.getClass().getMethod(setterName, int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }

        try {
            setter.invoke(player, currentValue + 1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }
    }
}