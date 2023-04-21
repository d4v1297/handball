package LOGIC.buissneslogic;

import MODEL.Player;

public class RateCalculator {

    public static double getThrowQuote(Player player) {

        int gesamtWuerfe = player.getGoalNine()
                + player.getGoalSeven()
                + player.getGoalSix()
                + player.getGoalBreakthrough()
                + player.getGoalCounterattack()
                + player.getMissedNine()
                + player.getMissedSeven()
                + player.getMissedSix()
                + player.getMissedBreakthrough()
                + player.getMissedCounterattack();

        int tore = player.getGoalNine()
                + player.getGoalSeven()
                + player.getGoalSix()
                + player.getGoalBreakthrough()
                + player.getGoalCounterattack();

        double quote = 0;
        if (gesamtWuerfe > 0) {
            quote = (double) tore / gesamtWuerfe * 100; // Umwandlung in double vor der Division
        }
        return quote;
    }

    public static double getParadeRate(Player player) {

        int gesamtWuerfe = player.getSaveNine()
                + player.getSaveSeven()
                + player.getSaveSix()
                + player.getSaveWing()
                + player.getSaveBreakthrough()
                + player.getSaveCounterattack()
                + player.getConcededNine()
                + player.getConcededSeven()
                + player.getConcededSix()
                + player.getConcededWing()
                + player.getConcededBreakthrough()
                + player.getConcededCounterattack();

        int paraden = player.getSaveNine()
                + player.getSaveSeven()
                + player.getSaveSix()
                + player.getSaveWing()
                + player.getSaveBreakthrough()
                + player.getSaveCounterattack();

        double quote = 0;
        if (gesamtWuerfe > 0) {
            quote = (double) paraden / gesamtWuerfe * 100; // Umwandlung in double vor der Division
        }
        return quote;
    }


}
