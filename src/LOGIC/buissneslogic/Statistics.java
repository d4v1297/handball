package LOGIC.buissneslogic;

import MODEL.Player;

import javax.swing.*;
import java.util.HashMap;

public class Statistics {
    public static void showStats(HashMap<String, Player> playerMap, JPanel statsPanel) {
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
            JLabel nameLabel = new JLabel(player.getName() + " (" + position + "), Nummer " + player.getNumber());
            //Ist Torhüter
            JLabel hitByKeeperLabel = null;
            JLabel missByKeeperLabel = null;
            JLabel saveNineLabel = null;
            JLabel saveSevenLabel = null;
            JLabel saveSixLabel = null;
            JLabel saveWingLabel = null;
            JLabel saveBreaktroughLabel = null;
            JLabel saveCounterattackLabel = null;
            JLabel concededSevenLabel = null;
            JLabel concededSixLabel = null;
            JLabel concededBreaktroughLabel = null;
            JLabel concededCounterattackLabel = null;
            JLabel concededNineLabel = null;
            if (player.isGoalkeeper()) {
                hitByKeeperLabel = new JLabel("Tor durch Torhüter" + player.getHitByKeeper());
                missByKeeperLabel = new JLabel("Fehlwurf durch Torhüter" + player.getMissByKeeper());
                saveNineLabel = new JLabel("Parade 9 Meter" + player.getSaveNine());
                saveSevenLabel = new JLabel("Parade 7 Meter" + player.getSaveSeven());
                saveSixLabel = new JLabel("Parade 6 Meter" + player.getSaveSix());
                saveWingLabel = new JLabel("Parade Flügel" + player.getSaveWing());
                saveBreaktroughLabel = new JLabel("Parade Durchbruch" + player.getSaveBreakthrough());
                saveCounterattackLabel = new JLabel("Parade Gegenstoß" + player.getSaveCounterattack());
                concededNineLabel = new JLabel("Gegentor 9 Meter" + player.getConcededNine());
                concededSevenLabel = new JLabel("Gegentor 7 Meter" + player.getConcededSeven());
                concededSixLabel = new JLabel("Gegentor 6 Meter" + player.getConcededSix());
                concededBreaktroughLabel = new JLabel("Gegentor Durchbruch" + player.getConcededBreakthrough());
                concededCounterattackLabel = new JLabel("Gegentor Gegenstoß" + player.getConcededCounterattack());

                //Quote berechnen
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

                double quote = paraden / gesamtWuerfe;

                JLabel paradenLabel = new JLabel("Quote" + quote);
            }

            JLabel lossOfBall = new JLabel("Ballverlust: " + String.valueOf(player.getAssist()));
            JLabel assist = new JLabel("Assists: " + String.valueOf(player.getAssist()));
            statsPanel.add(nameLabel);
            statsPanel.add(hitByKeeperLabel);
            statsPanel.add(missByKeeperLabel);
            statsPanel.add(saveNineLabel);
            statsPanel.add(saveSevenLabel);
            statsPanel.add(saveSixLabel);
            statsPanel.add(saveWingLabel);
            statsPanel.add(saveBreaktroughLabel);
            statsPanel.add(saveCounterattackLabel);
            statsPanel.add(concededNineLabel);
            statsPanel.add(concededSevenLabel);
            statsPanel.add(concededSixLabel);
            statsPanel.add(concededBreaktroughLabel);
            statsPanel.add(concededCounterattackLabel);

            // Hier können Sie weitere Labels oder andere Komponenten hinzufügen, um die Statistik anzuzeigen.
        }
    }
}
