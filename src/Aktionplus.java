import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Aktionplus {
    static void updatePlayerStats(Player player, String action) {
        switch (action) {
            // Torhüter-Aktionen
            case "hitByKeeper":
            case "missByKeeper":
            case "saveNine":
            case "saveSeven":
            case "saveSix":
            case "saveWing":
            case "saveBrakthrough":
            case "saveCounterattack":
            case "concededNine":
            case "concededSeven":
            case "concededSix":
            case "concededWing":
            case "concededBReakthrough":
            case "concededCounterattack":
                // Feldspieler Aktionen
            case "goalNine":
            case "goalSeven":
            case "goalSix":
            case "goalWing":
            case "goalBreakthrough":
                // Spieler Aktionen
            case "lossOfBall":
            case "ballWin":
            case "assist":
            case "fetchedSevenM":
            case "causedSevenM":
            case "fetchedTwoMinutes":
            case "yellowCard":
            case "twoMinutes":
            case "redCard":
            case "technicalMistake":
            case "passCatchMistake":
                incrementPlayerStat(player, action);
                break;
            default:
                throw new IllegalArgumentException("Unbekannte Aktion: " + action);
        }
    }

    private static void incrementPlayerStat(Player player, String action) {
        try {
            String methodName = "get" + action.substring(0, 1).toUpperCase() + action.substring(1);
            Method getter = player.getClass().getMethod(methodName);
            int currentValue = (int) getter.invoke(player);

            String setterName = "set" + action.substring(0, 1).toUpperCase() + action.substring(1);
            Method setter = player.getClass().getMethod(setterName, int.class);
            setter.invoke(player, currentValue + 1);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Fehler beim Aktualisieren der Spielerstatistik: " + action, e);
        }
    }


}
