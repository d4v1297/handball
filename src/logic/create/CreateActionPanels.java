package logic.create;

import javax.swing.*;

public class CreateActionPanels {
    //Spieler Radio Buttons
    private static JRadioButton lossOfBallRadioButton;
    private static JRadioButton ballWinRadioButton;
    private static JRadioButton assistRadioButton;
    private static JRadioButton technicalMistakeRadioButton;
    private static JRadioButton passCatchMistakeRadioButton;
    private static JRadioButton fetchedSevenMRadioButton;
    private static JRadioButton causedSevenMRadioButton;
    private static JRadioButton fetchedTwoMinutesRadioButton;
    private static JRadioButton yellowCardRadioButton;
    private static JRadioButton twoMinutesRadioButton;
    private static JRadioButton redCardRadioButton;
    //Torhüter Radio Buttons
    private static JRadioButton hitKeeperRadioButton;
    private static JRadioButton missKeeperRadioButton;
    private static JRadioButton saveNineRadioButton;
    private static JRadioButton saveSevenRadioButton;
    private static JRadioButton saveSixRadioButton;
    private static JRadioButton saveWingRadioButton;
    private static JRadioButton saveBreakthroughRadioButton;
    private static JRadioButton saveCounterattakRadioButton;
    private static JRadioButton concededNineRadioButton;
    private static JRadioButton concededSevenRadioButton;
    private static JRadioButton concededSixRadioButton;
    private static JRadioButton concededWingRadioButton;
    private static JRadioButton concededBreakthroughRadioButton;
    private static JRadioButton concededCounterattakRadioButton;
    //Feldspeler  Radio Buttons
    private static JRadioButton goalNineRadioButton;
    private static JRadioButton goalSevenRadioButton;
    private static JRadioButton goalSixRadioButton;
    private static JRadioButton goalWingRadioButton;
    private static JRadioButton goalBreakthroughRadioButton;
    private static JRadioButton goalCounterattakRadioButton;
    private static JRadioButton missedNineRadioButton;
    private static JRadioButton missedSevenRadioButton;
    private static JRadioButton missedSixRadioButton;
    private static JRadioButton missedWingRadioButton;
    private static JRadioButton missedBreakthroughRadioButton;
    private static JRadioButton missedCounterattakRadioButton;

    public static void createGoalkeeperActionPanel(JPanel actionPanel) {
        hitKeeperRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor durch Torhüter", "hitByKeeper");
        missKeeperRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf durch Torhüter", "missByKeeper");
        saveNineRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade 9m", "saveNine");
        saveSevenRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade 7m", "saveSeven");
        saveSixRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade 6m", "saveSix");
        saveWingRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade Flügel", "saveWing");
        saveBreakthroughRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade Durchbruch", "saveBrakthrough");
        saveCounterattakRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Parade Gegenstoß", "saveCounterattack");
        concededNineRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor 9m", "concededNine");
        concededSevenRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor 7m", "concededSeven");
        concededSixRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor 6m", "concededSix");
        concededWingRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor Flügel", "concededWing");
        concededBreakthroughRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor Durchbruch", "concededBreakthrough");
        concededCounterattakRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gegentor Gegenstoß", "concededCounterattack");
    }

    // Code für Feldspieler-Aktionen
    public static void createFieldPlayerActionPanel(JPanel actionPanel) {
        goalNineRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor 9m", "goalNine");
        goalSevenRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor 7m", "goalSeven");
        goalSixRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor 6m", "goalSix");
        goalWingRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor Flügel", "goalWing");
        goalBreakthroughRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor Durchbruch", "goalBreakthrough");
        goalCounterattakRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Tor Gegenstoß", "goalCounterattack");
        missedNineRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf 9m", "missedNine");
        missedSevenRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf 7m", "missedSeven");
        missedSixRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf 6m", "missedSix");
        missedWingRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf Flügel", "missedWing");
        missedBreakthroughRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf Durchbruch", "missedBreakthrough");
        missedCounterattakRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Fehlwurf Gegenstoß", "missedCounterattack");
    }

    public static void createCommonActionPanel(JPanel actionPanel) {
        lossOfBallRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Ballverlust", "lossOfBall");
        ballWinRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Ballgewinn", "ballWin");
        assistRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Assist", "assist");
        technicalMistakeRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Technischer Fehler", "technicalMistake");
        passCatchMistakeRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Pass-& Fangfehler", "passCatchMistake");
        fetchedSevenMRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "7m geholt", "fetchedSevenM");
        causedSevenMRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "7m verursacht", "causedSevenM");
        fetchedTwoMinutesRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "2 Minuten geholt", "fetchedTwoMinutes");
        yellowCardRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Gelbe Karte", "yellowCard");
        twoMinutesRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "2 Minuten", "twoMinutes");
        redCardRadioButton = CreateButtons.createAndAddRadioButton(actionPanel, "Rote Karte", "redCard");
    }
}