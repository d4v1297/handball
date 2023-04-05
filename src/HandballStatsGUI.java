import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class HandballStatsGUI extends JFrame implements ActionListener {
    private final JTextField nameField;
    private final JTextField numberField;
    private final JRadioButton fieldPlayerRadioButton;
    private final JRadioButton goalkeeperRadioButton;

    //Spieler Radio Buttons
    private JRadioButton lossOfBallRadioButton;
    private JRadioButton ballWinRadioButton;
    private JRadioButton assistRadioButton;
    private JRadioButton technicalMistakeRadioButton;
    private JRadioButton passCatchMistakeRadioButton;

    private JRadioButton fetchedSevenMRadioButton;
    private JRadioButton causedSevenMRadioButton;

    private JRadioButton fetchedTwoMinutesRadioButton;
    private JRadioButton yellowCardRadioButton;
    private JRadioButton twoMinutesRadioButton;
    private JRadioButton redCardRadioButton;

    //Torhüter Radio Buttons
    private JRadioButton hitKeeperRadioButton;
    private JRadioButton missKeeperRadioButton;

    private JRadioButton saveNineRadioButton;
    private JRadioButton saveSevenRadioButton;
    private JRadioButton saveSixRadioButton;
    private JRadioButton saveWingRadioButton;
    private JRadioButton saveBreakthroughRadioButton;
    private JRadioButton saveCounterattakRadioButton;

    private JRadioButton concededNineRadioButton;
    private JRadioButton concededSevenRadioButton;
    private JRadioButton concededSixRadioButton;
    private JRadioButton concededWingRadioButton;
    private JRadioButton concededBreakthroughRadioButton;
    private JRadioButton concededCounterattakRadioButton;

    //Feldspeler  Radio Buttons
    private JRadioButton goalNineRadioButton;
    private JRadioButton goalSevenRadioButton;
    private JRadioButton goalSixRadioButton;
    private JRadioButton goalWingRadioButton;
    private JRadioButton goalBreakthroughRadioButton;
    private JRadioButton goalCounterattakRadioButton;

    private JRadioButton missedNineRadioButton;
    private JRadioButton missedSevenRadioButton;
    private JRadioButton missedSixRadioButton;
    private JRadioButton missedWingRadioButton;
    private JRadioButton missedBreakthroughRadioButton;
    private JRadioButton missedCounterattakRadioButton;

    private final JButton savePlayerButton;
    private final JButton startGameButton;
    private final JTextArea playerListArea;
    private final HashMap<String, Player> playerMap;
    private JPanel gamePanel;

    public HandballStatsGUI() {
        // GUI-Fenster initialisieren
        setTitle("Handball-Statistik");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // GUI-Komponenten initialisieren
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel numberLabel = new JLabel("Trikotnummer:");
        numberField = new JTextField(20);

        fieldPlayerRadioButton = new JRadioButton("Feldspieler", true);
        goalkeeperRadioButton = new JRadioButton("Torhüter");
        ButtonGroup positionGroup = new ButtonGroup();
        positionGroup.add(fieldPlayerRadioButton);
        positionGroup.add(goalkeeperRadioButton);

        savePlayerButton = new JButton("Spieler speichern");
        savePlayerButton.addActionListener(this);

        startGameButton = new JButton("Spiel starten");
        startGameButton.addActionListener(this);

        playerListArea = new JTextArea(20, 30);
        playerListArea.setEditable(false);

        // GUI-Komponenten dem Fenster hinzufügen
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);
        inputPanel.add(fieldPlayerRadioButton);
        inputPanel.add(goalkeeperRadioButton);
        inputPanel.add(savePlayerButton);
        inputPanel.add(startGameButton);
        add(inputPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(playerListArea);
        add(scrollPane, BorderLayout.CENTER);

        // Spielerliste initialisieren
        playerMap = new HashMap<>();
    }


    // Event-Handler für den "Spieler speichern"-Button und "Spiel starten"-Button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == savePlayerButton) {
            // Spieler speichern Button wurde geklickt
            String name = nameField.getText();
            int number = Integer.parseInt(numberField.getText());
            boolean isGoalkeeper = goalkeeperRadioButton.isSelected();
            Player player = new Player(name, number, isGoalkeeper);
            playerMap.put(name, player);
            updatePlayerListArea();
            clearInputFields();
        } else if (e.getSource() == startGameButton) {
            // Spiel starten Button wurde geklickt
            gamePanel = new JPanel(new GridLayout(playerMap.size(), 2));

            // Spielerliste und Aktionen hinzufügen
            for (String name : playerMap.keySet()) {
                Player player = playerMap.get(name);
                String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
                JLabel playerLabel = new JLabel(name + " (" + position + "), Nummer " + player.getNumber());
                JButton actionButton = new JButton("Aktion");
                actionButton.addActionListener(e1 -> {
                    // Aktion-Button wurde geklickt
                    JPanel actionPanel = new JPanel(new GridLayout(3, 1));
                    if (player.isGoalkeeper()) {

                        hitKeeperRadioButton = new JRadioButton("Tor durch Torhüter");
                        missKeeperRadioButton = new JRadioButton("Fehlwurf durch Torhüter");

                        saveNineRadioButton = new JRadioButton("Parade 9m");
                        saveSevenRadioButton = new JRadioButton("Parade 7m");
                        saveSixRadioButton = new JRadioButton("Parade 6m");
                        saveWingRadioButton = new JRadioButton("Parade Flügel");
                        saveBreakthroughRadioButton = new JRadioButton("Parade Durchbruch");
                        saveCounterattakRadioButton = new JRadioButton("Parade Gegenstoß");

                        concededNineRadioButton = new JRadioButton("Gegentor 9m");
                        concededSevenRadioButton = new JRadioButton("Gegentor 7m");
                        concededSixRadioButton = new JRadioButton("Gegentor 6m");
                        concededWingRadioButton = new JRadioButton("Gegentor Flügel");
                        concededBreakthroughRadioButton = new JRadioButton("Gegentor Durchbruch");
                        concededCounterattakRadioButton = new JRadioButton("Gegentor Gegenstoß");


                        actionPanel.add(hitKeeperRadioButton);
                        actionPanel.add(missKeeperRadioButton);

                        actionPanel.add(saveNineRadioButton);
                        actionPanel.add(saveSevenRadioButton);
                        actionPanel.add(saveSixRadioButton);
                        actionPanel.add(saveWingRadioButton);
                        actionPanel.add(saveBreakthroughRadioButton);
                        actionPanel.add(saveCounterattakRadioButton);

                        actionPanel.add(concededNineRadioButton);
                        actionPanel.add(concededSevenRadioButton);
                        actionPanel.add(concededSixRadioButton);
                        actionPanel.add(concededWingRadioButton);
                        actionPanel.add(concededBreakthroughRadioButton);
                        actionPanel.add(concededCounterattakRadioButton);

                    } else if (!player.isGoalkeeper()) {
                        goalNineRadioButton = new JRadioButton("Tor 9m");
                        goalSevenRadioButton = new JRadioButton("Tor 7m");
                        goalSixRadioButton = new JRadioButton("Tor 6m");
                        goalWingRadioButton = new JRadioButton("Tor Flügel");
                        goalBreakthroughRadioButton = new JRadioButton("Tor Durchbruch");
                        goalCounterattakRadioButton = new JRadioButton("Tor Gegenstoß");

                        missedNineRadioButton = new JRadioButton("Fehlwurf 9m");
                        missedSevenRadioButton = new JRadioButton("Fehlwurf 7m");
                        missedSixRadioButton = new JRadioButton("Fehlwurf 6m");
                        missedWingRadioButton = new JRadioButton("Fehlwurf Flügel");
                        missedBreakthroughRadioButton = new JRadioButton("Fehlwurf Durchbruch");
                        missedCounterattakRadioButton = new JRadioButton("Fehlwurf Gegenstoß");

                        actionPanel.add(goalNineRadioButton);
                        actionPanel.add(goalSevenRadioButton);
                        actionPanel.add(goalSixRadioButton);
                        actionPanel.add(goalWingRadioButton);
                        actionPanel.add(goalBreakthroughRadioButton);
                        actionPanel.add(goalCounterattakRadioButton);

                        actionPanel.add(missedNineRadioButton);
                        actionPanel.add(missedSevenRadioButton);
                        actionPanel.add(missedSixRadioButton);
                        actionPanel.add(missedWingRadioButton);
                        actionPanel.add(missedBreakthroughRadioButton);
                        actionPanel.add(missedCounterattakRadioButton);

                    }

                    lossOfBallRadioButton = new JRadioButton("Ballverlust");
                    ballWinRadioButton = new JRadioButton("Ballgewinn");
                    assistRadioButton = new JRadioButton("Assist");
                    technicalMistakeRadioButton = new JRadioButton("Technischer Fehler");
                    passCatchMistakeRadioButton = new JRadioButton("Pass-& Fangfehler");

                    fetchedSevenMRadioButton = new JRadioButton("7m geholt");
                    causedSevenMRadioButton = new JRadioButton("7m verursacht");

                    fetchedTwoMinutesRadioButton = new JRadioButton("2 Minuten geholt");
                    yellowCardRadioButton = new JRadioButton("Gelbe Karte");
                    twoMinutesRadioButton = new JRadioButton("2 Minuten");
                    redCardRadioButton = new JRadioButton("Rote Karte");

                    actionPanel.add(lossOfBallRadioButton);
                    actionPanel.add(ballWinRadioButton);
                    actionPanel.add(assistRadioButton);
                    actionPanel.add(fetchedSevenMRadioButton);
                    actionPanel.add(causedSevenMRadioButton);
                    actionPanel.add(fetchedTwoMinutesRadioButton);
                    actionPanel.add(yellowCardRadioButton);
                    actionPanel.add(twoMinutesRadioButton);
                    actionPanel.add(redCardRadioButton);
                    actionPanel.add(technicalMistakeRadioButton);
                    actionPanel.add(passCatchMistakeRadioButton);

                    int result = JOptionPane.showConfirmDialog(gamePanel, actionPanel, "Aktion für " + name, JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        //Würfe Torhüter
                        if (hitKeeperRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "hitByKeeper");
                        } else if (missKeeperRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missByKeeper");
                        }
                        //Paraden Tohüter
                        else if (saveNineRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveNine");
                        } else if (saveSevenRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveSeven");
                        } else if (saveSixRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveSix");
                        } else if (saveWingRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveWing");
                        } else if (saveBreakthroughRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveBreakthrough");
                        } else if (saveCounterattakRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "saveCounterattack");
                        }
                        //Gegentor Tohüter
                        else if (concededNineRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededNine");
                        } else if (concededSevenRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededSeven");
                        } else if (concededSixRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededSix");
                        } else if (concededWingRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededWing");
                        } else if (concededBreakthroughRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededBreakthrough");
                        } else if (concededCounterattakRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "concededCounterattack");
                        }
                        //Tore Feldspieler
                        else if (goalNineRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalNine");
                        } else if (goalSevenRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalSeven");
                        } else if (goalSixRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalSix");
                        } else if (goalWingRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalWing");
                        } else if (goalBreakthroughRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalBreakthrough");
                        } else if (goalCounterattakRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "goalCounterattack");
                        }
                        //Fehlwürfe Torhüter
                        else if (missedNineRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedNine");
                        } else if (missedSevenRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedSeven");
                        } else if (missedSixRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedSix");
                        } else if (missedWingRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedWing");
                        } else if (missedBreakthroughRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedBreakthrough");
                        } else if (missedCounterattakRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "missedCounterattack");
                        }
                        //Aktionen Spieler
                        else if (lossOfBallRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "lossOfBall");
                        } else if (ballWinRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "ballWin");
                        } else if (assistRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "assist");
                        } else if (fetchedSevenMRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "fetchedSevenM");
                        } else if (causedSevenMRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "causedSevenM");
                        } else if (fetchedTwoMinutesRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "fetchedTwoMinutes");
                        } else if (yellowCardRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "yellowCard");
                        } else if (twoMinutesRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "twoMinutes");
                        } else if (redCardRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "redCard");
                        } else if (technicalMistakeRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "technicalMistake");
                        } else if (passCatchMistakeRadioButton.isSelected()) {
                            Aktionplus.updatePlayerStats(player, "passCatchMistake");
                        }
                        updatePlayerListArea();
                    }
                });
                gamePanel.add(playerLabel);
                gamePanel.add(actionButton);
            }

            // Formular ausblenden und das neue Panel anzeigen
            getContentPane().removeAll();
            add(gamePanel);
            validate();
            repaint();
        }
    }

    // Methode zum Aktualisieren der Spielerliste-Anzeige
    private void updatePlayerListArea() {
        playerListArea.setText("");
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
            playerListArea.append(name + " (" + position + "), Nummer " + player.getNumber() + "\n");
        }
    }

    // Methode zum Leeren der Eingabefelder
    private void clearInputFields() {
        nameField.setText("");
        numberField.setText("");
        fieldPlayerRadioButton.setSelected(true);
        nameField.requestFocus();
    }

    public static void main(String[] args) {
        HandballStatsGUI gui = new HandballStatsGUI();
        gui.setVisible(true);
    }
}
