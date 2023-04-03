import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HandballStatsGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField numberField;
    private JRadioButton fieldPlayerRadioButton;
    private JRadioButton goalkeeperRadioButton;

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

    private JButton savePlayerButton;
    private JButton startGameButton;
    private JTextArea playerListArea;
    private HashMap<String, Player> playerMap;
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
                actionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Aktion-Button wurde geklickt
                        JPanel actionPanel = new JPanel(new GridLayout(3, 1));
                        ButtonGroup actionGroup = new ButtonGroup();
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
                        /*if (result == JOptionPane.OK_OPTION) {
                            if (hitKeeperRadioButton.isSelected()) {
                                // Tor erzielt
                                player.incrementGoals();
                            } else if (missKeeperRadioButton.isSelected()) {
                                // Fehlwurf
                                player.incrementMisses();
                            } else if (saveNineRadioButton.isSelected()) {
                                // Assist
                                player.incrementAssists();
                            }
                            updatePlayerListArea();
                        }*/
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
