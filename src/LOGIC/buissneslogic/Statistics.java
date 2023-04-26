package LOGIC.buissneslogic;

import MODEL.Player;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Statistics {
    public static void showStats(HashMap<String, Player> playerMap, JPanel statsPanel) {

        ResultCalculator.getTore(playerMap);
        ResultCalculator.getGegenTore(playerMap);
        JLabel tore = new JLabel("Tore: " + ResultCalculator.getTore(playerMap));
        JLabel gegenTore = new JLabel("Gegentore: " + ResultCalculator.getGegenTore(playerMap));
        statsPanel.add(tore);
        statsPanel.add(gegenTore);

        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
            JLabel nameLabel = new JLabel(player.getName() + " (" + position + "), Nummer " + player.getNumber());
            //Ist Torhüter
            if (player.isGoalkeeper()) {
                JLabel hitByKeeper = new JLabel("Tor durch Torhüter: " + player.getHitByKeeper());
                JLabel missByKeeper = new JLabel("Fehlwurf durch Torhüter: " + player.getMissByKeeper());
                JLabel saveNine = new JLabel("Parade 9 Meter: " + player.getSaveNine());
                JLabel saveSeven = new JLabel("Parade 7 Meter: " + player.getSaveSeven());
                JLabel saveSix = new JLabel("Parade 6 Meter: " + player.getSaveSix());
                JLabel saveWing = new JLabel("Parade Flügel: " + player.getSaveWing());
                JLabel saveBreaktrough = new JLabel("Parade Durchbruch: " + player.getSaveBreakthrough());
                JLabel saveCounterattack = new JLabel("Parade Gegenstoß: " + player.getSaveCounterattack());
                JLabel concededNine = new JLabel("Gegentor 9 Meter: " + player.getConcededNine());
                JLabel concededSeven = new JLabel("Gegentor 7 Meter: " + player.getConcededSeven());
                JLabel concededSix = new JLabel("Gegentor 6 Meter: " + player.getConcededSix());
                JLabel concededWing = new JLabel("Gegentor Flügel: " + player.getConcededSix());
                JLabel concededBreaktrough = new JLabel("Gegentor Durchbruch: " + player.getConcededBreakthrough());
                JLabel concededCounterattack = new JLabel("Gegentor Gegenstoß: " + player.getConcededCounterattack());

                //Calc Parade
                JLabel paradenLabel = new JLabel("Quote" + RateCalculator.getParadeRate(player) + "%");

                statsPanel.add(nameLabel);
                statsPanel.add(paradenLabel);
                statsPanel.add(hitByKeeper);
                statsPanel.add(missByKeeper);
                statsPanel.add(saveNine);
                statsPanel.add(saveSeven);
                statsPanel.add(saveSix);
                statsPanel.add(saveWing);
                statsPanel.add(saveBreaktrough);
                statsPanel.add(saveCounterattack);
                statsPanel.add(concededNine);
                statsPanel.add(concededSeven);
                statsPanel.add(concededSix);
                statsPanel.add(concededWing);
                statsPanel.add(concededBreaktrough);
                statsPanel.add(concededCounterattack);
            }
            if (!player.isGoalkeeper()) {
                JLabel goalNine = new JLabel("Tor 9 Meter: " + player.getHitByKeeper());
                JLabel goalSeven = new JLabel("Tor 7 Meter: " + player.getMissByKeeper());
                JLabel goalSix = new JLabel("Tor 6 Meter: " + player.getSaveNine());
                JLabel goalWing = new JLabel("Tor Flügel: " + player.getSaveSeven());
                JLabel goalBreakthrough = new JLabel("Tor Durchbruch: : " + player.getSaveSix());
                JLabel goalCounterattack = new JLabel("Tor Gegenstoß: : " + player.getSaveWing());
                JLabel missedNine = new JLabel("Fehlwurf 9 Meter : " + player.getSaveBreakthrough());
                JLabel missedSeven = new JLabel("Fehlwurf 7 Meter : " + player.getSaveCounterattack());
                JLabel missedSix = new JLabel("Fehlwurf 6 Meter : " + player.getConcededNine());
                JLabel missedWing = new JLabel("Fehlwurf Flügel : " + player.getConcededSeven());
                JLabel missedBreakthrough = new JLabel("Fehlwurf Durchbruch : " + player.getConcededSix());
                JLabel missedCounterattack = new JLabel("Fehlwurf Gegenstoß : " + player.getConcededSix());


                //Wurfquote

                JLabel quotenLabel = new JLabel("Quote" + RateCalculator.getThrowQuote(player) + "%");

                statsPanel.add(nameLabel);
                statsPanel.add(quotenLabel);
                statsPanel.add(goalNine);
                statsPanel.add(goalSeven);
                statsPanel.add(goalSix);
                statsPanel.add(goalWing);
                statsPanel.add(goalBreakthrough);
                statsPanel.add(goalCounterattack);
                statsPanel.add(missedNine);
                statsPanel.add(missedSeven);
                statsPanel.add(missedSix);
                statsPanel.add(missedWing);
                statsPanel.add(missedBreakthrough);
                statsPanel.add(missedCounterattack);
            }

            JLabel lossOfBall = new JLabel("Ballverlust: " + player.getLossOfBall());
            JLabel ballWin = new JLabel("Ballgewinn: " + player.getBallWin());
            JLabel assist = new JLabel("Assist: " + player.getAssist());
            JLabel fetchedSevenM = new JLabel("Parade 7 Meter: " + player.getFetchedSevenM());
            JLabel causedSevenM = new JLabel("Parade 6 Meter: " + player.getCausedSevenM());
            JLabel fetchedTwoMinutes = new JLabel("Parade Flügel: " + player.getFetchedTwoMinutes());
            JLabel yellowCard = new JLabel("Parade Durchbruch: " + player.getYellowCard());
            JLabel twoMinutes = new JLabel("Parade Gegenstoß: " + player.getTwoMinutes());
            JLabel redCard = new JLabel("Gegentor 9 Meter: " + player.getRedCard());
            JLabel technicalMistake = new JLabel("Gegentor 7 Meter: " + player.getTechnicalMistake());
            JLabel passCatchMistake = new JLabel("Gegentor 6 Meter: " + player.getPassCatchMistake());
            JLabel platzhalter = new JLabel("");

            statsPanel.add(lossOfBall);
            statsPanel.add(ballWin);
            statsPanel.add(assist);
            statsPanel.add(fetchedSevenM);
            statsPanel.add(causedSevenM);
            statsPanel.add(fetchedTwoMinutes);
            statsPanel.add(yellowCard);
            statsPanel.add(twoMinutes);
            statsPanel.add(redCard);
            statsPanel.add(technicalMistake);
            statsPanel.add(passCatchMistake);
            statsPanel.add(platzhalter);
        }
    }
}
