package LOGIC.buissneslogic;

import MODEL.Player;

import java.util.HashMap;

public class ResultCalculator {

    public static int getTore(HashMap<String, Player> playerMap) {
        int tore_gesamt = 0;
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            if (player.isGoalkeeper()) {
                tore_gesamt = tore_gesamt + getKeeperTore(player);
            } else if (!player.isGoalkeeper()) {
                tore_gesamt = tore_gesamt + getPlayerTore(player);
            }
        }
        return tore_gesamt;
    }

    private static int getPlayerTore(Player player) {
        int tore = player.getGoalNine()
                + player.getGoalSeven()
                + player.getGoalSix()
                + player.getGoalWing()
                + player.getGoalBreakthrough()
                + player.getGoalCounterattack();
        return tore;
    }

    private static int getKeeperTore(Player player) {
        int keeperTore = player.getHitByKeeper();
        return keeperTore;
    }


    public static int getGegenTore(HashMap<String, Player> playerMap) {
        int gegentore_gesamt = 0;
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            if (player.isGoalkeeper()) {
                gegentore_gesamt = gegentore_gesamt + getKeeperGegentore(player);
            }
        }
        return gegentore_gesamt;
    }

    private static int getKeeperGegentore(Player player) {
        int gegentore = player.getConcededNine()
                + player.getConcededSeven()
                + player.getConcededSix()
                + player.getConcededWing()
                + player.getConcededBreakthrough()
                + player.getConcededCounterattack();
        return gegentore;
    }
}
