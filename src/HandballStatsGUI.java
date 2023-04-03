import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HandballStatsGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField numberField;
    private JRadioButton fieldPlayerRadioButton;
    private JRadioButton goalkeeperRadioButton;

    //Torhüter Radio Buttons
    private JRadioButton hitKeeperRadioButton;
    private JRadioButton missKeeperRadioButton;
    private JRadioButton saveNineRadioButton;
    private JRadioButton saveSevenRadioButton;
    private JRadioButton saveSixRadioButton;
    private JRadioButton saveWingRadioButton;
    private JRadioButton saveBreakthroughRadioButton;
    private JRadioButton saveCounterattakRadioButton;
    private JRadioButton lossOfBallRadioButton;
    private JRadioButton ballWinRadioButton;
    private JRadioButton assistRadioButton;
    private JRadioButton fetchedSevenMRadioButton;
    private JRadioButton causedSevenMRadioButton;
    private JRadioButton fetchedTwoMinutesRadioButton;
    private JRadioButton yellowCardRadioButton;
    private JRadioButton twoMinutesRadioButton;
    private JRadioButton redCardRadioButton;
    private JRadioButton technicalMistakeRadioButton;
    private JRadioButton passCatchMistakeRadioButton;
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
//TODO
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
                        hitKeeperRadioButton = new JRadioButton("Tor durch Torhüter");
                        missKeeperRadioButton = new JRadioButton("Fehlwurf durch Torhüter");
                        saveNineRadioButton = new JRadioButton("Parade 9m");
                        saveSevenRadioButton = new JRadioButton("Parade 7m");
                        saveSixRadioButton = new JRadioButton("Parade 6m");
                        saveWingRadioButton = new JRadioButton("Parade Flügel");
                        saveBreakthroughRadioButton = new JRadioButton("Parade Durchbruch");
                        saveCounterattakRadioButton = new JRadioButton("Parade Gegenstoß");
                        lossOfBallRadioButton = new JRadioButton("Ballverlust");
                        ballWinRadioButton = new JRadioButton("Ballgewinn");
                        assistRadioButton = new JRadioButton("Assist");
                        fetchedSevenMRadioButton = new JRadioButton("7m geholt");
                        causedSevenMRadioButton = new JRadioButton("7m verursacht");
                        fetchedTwoMinutesRadioButton = new JRadioButton("2 Minuten geholt");
                        yellowCardRadioButton = new JRadioButton("Gelbe Karte");
                        twoMinutesRadioButton = new JRadioButton("2 Minuten");
                        redCardRadioButton = new JRadioButton("Rote Karte");
                        technicalMistakeRadioButton = new JRadioButton("Technischer Fehler");
                        passCatchMistakeRadioButton = new JRadioButton("Pass-& Fangfehler");
                        ButtonGroup actionGroup = new ButtonGroup();
                        actionGroup.add(hitKeeperRadioButton);
                        actionGroup.add(missKeeperRadioButton);
                        actionGroup.add(saveNineRadioButton);
                        actionPanel.add(saveSevenRadioButton);
                        actionPanel.add(saveSixRadioButton);
                        actionPanel.add(saveWingRadioButton);
                        actionPanel.add(saveBreakthroughRadioButton);
                        actionPanel.add(saveCounterattakRadioButton);
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
                        }
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


    // Methode zum Durchführen einer Aktion für einen bestimmten Spieler
    private void performAction(Player player) {
        // Dialog-Fenster für Aktionen anzeigen
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
            hitKeeperRadioButton = new JRadioButton("Tor durch Torhüter");
            missKeeperRadioButton = new JRadioButton("Fehlwurf durch Torhüter");
            saveNineRadioButton = new JRadioButton("Parade 9m");
            saveSevenRadioButton = new JRadioButton("Parade 7m");
            saveSixRadioButton = new JRadioButton("Parade 6m");
            saveWingRadioButton = new JRadioButton("Parade Flügel");
            saveBreakthroughRadioButton = new JRadioButton("Parade Durchbruch");
            saveCounterattakRadioButton = new JRadioButton("Parade Gegenstoß");
            lossOfBallRadioButton = new JRadioButton("Ballverlust");
            ballWinRadioButton = new JRadioButton("Ballgewinn");
            assistRadioButton = new JRadioButton("Assist");
            fetchedSevenMRadioButton = new JRadioButton("7m geholt");
            causedSevenMRadioButton = new JRadioButton("7m verursacht");
            fetchedTwoMinutesRadioButton = new JRadioButton("2 Minuten geholt");
            yellowCardRadioButton = new JRadioButton("Gelbe Karte");
            twoMinutesRadioButton = new JRadioButton("2 Minuten");
            redCardRadioButton = new JRadioButton("Rote Karte");
            technicalMistakeRadioButton = new JRadioButton("Technischer Fehler");
            passCatchMistakeRadioButton = new JRadioButton("Pass-& Fangfehler");

            ButtonGroup actionGroup = new ButtonGroup();

            actionGroup.add(hitKeeperRadioButton);
            actionGroup.add(missKeeperRadioButton);
            actionGroup.add(saveNineRadioButton);
            actionPanel.add(saveSevenRadioButton);
            actionPanel.add(saveSixRadioButton);
            actionPanel.add(saveWingRadioButton);
            actionPanel.add(saveBreakthroughRadioButton);
            actionPanel.add(saveCounterattakRadioButton);
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

        int result = JOptionPane.showConfirmDialog(null, actionPanel, "Aktion auswählen", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Aktion-Button wurde geklickt
            if (hitKeeperRadioButton.isSelected()) {
                // Treffer
                // Implementieren Sie hier die Logik, um einen Treffer für den Spieler durchzuführen
                // Aktualisieren Sie gegebenenfalls die Anzeige in der gamePanel
            } else if (missKeeperRadioButton.isSelected()) {
                // Fehlwurf
                // Implementieren Sie hier die Logik, um einen Fehlwurf für den Spieler durchzuführen
                // Aktualisieren Sie gegebenenfalls die Anzeige in der gamePanel
            } else if (saveNineRadioButton.isSelected()) {
                // Block
                // Implementieren Sie hier die Logik, um einen Block für den Spieler durchzuführen
                // Aktualisieren Sie gegebenenfalls die Anzeige in der gamePanel
            }
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
