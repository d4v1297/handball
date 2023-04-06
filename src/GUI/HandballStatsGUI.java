package GUI;

import Model.Player;
import LOGIC.UpdateAndIncrement;
import LOGIC.create.CreateActionPanels;
import LOGIC.create.CreateButtons;
import LOGIC.create.CreateText;
import LOGIC.create.LookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HandballStatsGUI extends JFrame implements ActionListener {

    // Textfelder für den Namen und die Nummer des Spielers
    private JTextField nameField;
    private JTextField numberField;

    // Radio-Buttons für die Position des Spielers
    private JRadioButton fieldPlayerRadioButton; // Feldspieler
    private JRadioButton goalkeeperRadioButton; // Torhüter

    // Buttons zum Speichern eines Spielers und zum Starten des Spiels
    private JButton savePlayerButton;
    private JButton startGameButton;

    // Textbereich zur Anzeige der Liste der Spieler
    private JTextArea playerListArea;

    // HashMap zur Speicherung der Spieler mit dem Namen als Schlüssel
    private final HashMap<String, Player> playerMap;

    // JPanel für das Spiel
    private JPanel gamePanel;

    // JPanel für die Statistik
    private JPanel statsPanel;

    /**
     * Konstruktor der HandballStatsGUI Klasse.
     * Setzt den Titel des Fensters, die Größe, die Schließaktion und die Position.
     * Initialisiert die grafischen Komponenten.
     * Erstellt eine leere HashMap zur Speicherung der Spielerdaten.
     */
    public HandballStatsGUI() {
        setTitle("Handball-Statistik"); // Setzt den Titel des Fensters
        setSize(400, 500); // Setzt die Größe des Fensters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setzt die Schließaktion des Fensters
        setLocationRelativeTo(null); // Setzt die Position des Fensters auf die Mitte des Bildschirms

        initGUIComponents(); // Initialisiert die grafischen Komponenten

        playerMap = new HashMap<>(); // Erstellt eine leere HashMap zur Speicherung der Spielerdaten
    }

    /**
     * Methode zur Initialisierung der grafischen Komponenten der Handball-Statistik-Anwendung.
     * Setzt das Look-and-Feel der Anwendung.
     * Erstellt Textfelder für den Namen und die Rückennummer des Spielers.
     * Erstellt Radio-Buttons für die Position des Spielers.
     * Erstellt eine Button-Gruppe für die Radio-Buttons.
     * Erstellt Buttons zum Speichern eines Spielers und zum Starten eines Spiels.
     * Erstellt eine TextArea zur Anzeige der Spielerliste.
     * Fügt die Komponenten zum Input-Panel und zur Hauptanzeige hinzu.
     */
    private void initGUIComponents() {
        LookAndFeel.setLookAndFeel(); // Setzt das Look-and-Feel der Anwendung

        nameField = CreateText.createTextField(20); // Erstellt ein Textfeld für den Namen des Spielers
        numberField = CreateText.createTextField(20); // Erstellt ein Textfeld für die Rückennummer des Spielers

        fieldPlayerRadioButton = CreateButtons.createRadioButton("Feldspieler", true); // Erstellt einen Radio-Button für Feldspieler und setzt ihn auf aktiv
        goalkeeperRadioButton = CreateButtons.createRadioButton("Torhüter", false); // Erstellt einen Radio-Button für Torhüter und setzt ihn auf inaktiv
        ButtonGroup positionGroup = new ButtonGroup(); // Erstellt eine Button-Gruppe für die Radio-Buttons
        positionGroup.add(fieldPlayerRadioButton); // Fügt den Feldspieler-Radio-Button zur Button-Gruppe hinzu
        positionGroup.add(goalkeeperRadioButton); // Fügt den Torhüter-Radio-Button zur Button-Gruppe hinzu

        savePlayerButton = CreateButtons.createButton("Spieler speichern", this); // Erstellt einen Button zum Speichern eines Spielers und weist den ActionListener zu
        startGameButton = CreateButtons.createButton("Spiel starten", this); // Erstellt einen Button zum Starten eines Spiels und weist den ActionListener zu

        playerListArea = CreateText.createTextArea(20, 30); // Erstellt eine TextArea zur Anzeige der Spielerliste

        addInputPanel(); // Fügt die Input-Komponenten zum Input-Panel hinzu
        JScrollPane scrollPane = new JScrollPane(playerListArea); // Erstellt einen JScrollPane mit der Spielerliste als Inhalt
        add(scrollPane, BorderLayout.CENTER); // Fügt den JScrollPane zur Hauptanzeige hinzu
    }

    /**
     * Methode zum Hinzufügen der Input-Komponenten zum Input-Panel.
     * Erstellt ein JPanel mit einem BoxLayout.
     * Fügt ein Label und ein Textfeld für den Namen des Spielers hinzu.
     * Fügt ein Label und ein Textfeld für die Rückennummer des Spielers hinzu.
     * Fügt die Radio-Buttons für die Position des Spielers hinzu.
     * Fügt den Button zum Speichern eines Spielers hinzu.
     * Fügt den Button zum Starten eines Spiels hinzu.
     * Fügt das Input-Panel zur Hauptanzeige hinzu.
     */
    private void addInputPanel() {
        JPanel inputPanel = new JPanel(); // Erstellt ein JPanel
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Setzt das Layout des JPanels auf ein vertikales BoxLayout

        CreateText.addLabelAndTextField(inputPanel, "Name:", nameField); // Fügt ein Label und ein Textfeld für den Namen des Spielers zum JPanel hinzu
        CreateText.addLabelAndTextField(inputPanel, "Trikotnummer:", numberField); // Fügt ein Label und ein Textfeld für die Rückennummer des Spielers zum JPanel hinzu

        inputPanel.add(fieldPlayerRadioButton); // Fügt den Radio-Button für Feldspieler zum JPanel hinzu
        inputPanel.add(goalkeeperRadioButton); // Fügt den Radio-Button für Torhüter zum JPanel hinzu
        inputPanel.add(savePlayerButton); // Fügt den Button zum Speichern eines Spielers zum JPanel hinzu
        inputPanel.add(startGameButton); // Fügt den Button zum Starten eines Spiels zum JPanel hinzu

        add(inputPanel, BorderLayout.NORTH); // Fügt das Input-Panel zur Hauptanzeige hinzu
    }

    /**
     * Methode zur Behandlung von ActionEvents.
     * Prüft, ob das Event von dem Speichern-Button oder dem Start-Button ausgelöst wurde.
     * Ruft die entsprechende Methode zur Behandlung des Events auf.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == savePlayerButton) { // Prüft, ob das Event von dem Speichern-Button ausgelöst wurde
            handleSavePlayerButton(); // Ruft die Methode zur Behandlung des Speichern-Buttons auf
        } else if (e.getSource() == startGameButton) { // Prüft, ob das Event von dem Start-Button ausgelöst wurde
            handleStartGameButton(); // Ruft die Methode zur Behandlung des Start-Buttons auf
        }
    }

    /**
     * Methode zur Aktualisierung der Spielerliste-Anzeige.
     * Löscht den Text in der TextArea für die Spielerliste.
     * Iteriert über die Spieler in der Spieler-HashMap und gibt deren Namen, Position und Rückennummer aus.
     * Fügt die Informationen zur TextArea für die Spielerliste hinzu.
     */
    public void updatePlayerListArea() {
        playerListArea.setText(""); // Löscht den Text in der TextArea für die Spielerliste
        for (String name : playerMap.keySet()) { // Iteriert über die Spieler in der Spieler-HashMap
            Player player = playerMap.get(name);
            String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler"; // Prüft, ob der Spieler ein Torhüter ist
            playerListArea.append(name + " (" + position + "), Nummer " + player.getNumber() + "\n"); // Fügt die Informationen zum Spieler zur TextArea für die Spielerliste hinzu
        }
    }

    /**
     * Methode zur Behandlung des Speichern-Buttons.
     * Holt den Namen, die Rückennummer und die Position des Spielers aus den Textfeldern und Radio-Buttons.
     * Erstellt einen neuen Spieler mit den erhaltenen Informationen und fügt ihn der Spieler-HashMap hinzu.
     * Aktualisiert die Anzeige der Spielerliste und leert die Eingabefelder.
     */
    private void handleSavePlayerButton() {
        String name = nameField.getText(); // Holt den Namen des Spielers aus dem Textfeld
        int number = Integer.parseInt(numberField.getText()); // Holt die Rückennummer des Spielers aus dem Textfeld und konvertiert den String in eine Integer-Zahl
        boolean isGoalkeeper = goalkeeperRadioButton.isSelected(); // Prüft, ob der Torhüter-Radio-Button ausgewählt ist
        Player player = new Player(name, number, isGoalkeeper); // Erstellt einen neuen Spieler mit den erhaltenen Informationen
        playerMap.put(name, player); // Fügt den Spieler zur Spieler-HashMap hinzu
        updatePlayerListArea(); // Aktualisiert die Anzeige der Spielerliste
        clearInputFields(); // Leert die Eingabefelder
    }


    /**
     * Methode zur Behandlung des Start-Buttons.
     * Erstellt ein neues JPanel für das Spiel-Panel mit einem GridLayout basierend auf der Anzahl der gespeicherten Spieler.
     * Iteriert über die Spieler in der Spieler-HashMap und fügt für jeden Spieler ein Label und einen Aktions-Button zum JPanel hinzu.
     * Erstellt einen neuen Button für die Statistik-Ansicht und fügt ihm einen ActionListener hinzu, der die Statistik-Panel erstellt.
     * Entfernt alle vorhandenen Komponenten aus dem ContentPane.
     * Fügt das Spiel-Panel zum ContentPane hinzu und aktualisiert das Layout.
     */
    private void handleStartGameButton() {
        gamePanel = new JPanel(new GridLayout(playerMap.size(), 2)); // Erstellt ein neues JPanel für das Spiel-Panel mit einem GridLayout basierend auf der Anzahl der gespeicherten Spieler
        for (String name : playerMap.keySet()) { // Iteriert über die Spieler in der Spieler-HashMap
            Player player = playerMap.get(name);
            addPlayerLabelAndActionButton(player); // Fügt für jeden Spieler ein Label und einen Aktions-Button zum JPanel hinzu
        }
        JButton statsButtton = new JButton("Statistik"); // Erstellt einen neuen Button für die Statistik-Ansicht
        statsButtton.addActionListener(e1 -> { // Fügt einen ActionListener zum Button hinzu, der die Statistik-Panel erstellt
            statsPanel = new JPanel(new GridLayout(playerMap.size(), 2));
        });
        getContentPane().removeAll(); // Entfernt alle vorhandenen Komponenten aus dem ContentPane
        add(gamePanel); // Fügt das Spiel-Panel zum ContentPane hinzu
        validate(); // Aktualisiert das Layout
        repaint();
    }

    /**
     * Methode zum Hinzufügen eines Labels und eines Aktions-Buttons für einen Spieler zum Spiel-Panel.
     * Holt die Position des Spielers aus dem Spieler-Objekt.
     * Erstellt ein neues JLabel mit dem Namen, der Position und der Rückennummer des Spielers.
     * Erstellt einen neuen Aktions-Button mit einem ActionListener, der ein neues JPanel für die Aktion erstellt.
     * Zeigt das JPanel in einem JOptionPane an und führt die Aktion aus, wenn der OK-Button gedrückt wird.
     * Aktualisiert die Anzeige der Spielerliste.
     */
    private void addPlayerLabelAndActionButton(Player player) {
        String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler"; // Holt die Position des Spielers aus dem Spieler-Objekt
        JLabel playerLabel = new JLabel(player.getName() + " (" + position + "), Nummer " + player.getNumber()); // Erstellt ein neues JLabel mit dem Namen, der Position und der Rückennummer des Spielers
        JButton actionButton = new JButton("Aktion"); // Erstellt einen neuen Aktions-Button mit einem ActionListener
        actionButton.addActionListener(e1 -> {
            JPanel actionPanel = CreateActionPanels.createActionPanel(player); // Erstellt ein neues JPanel für die Aktion
            int result = JOptionPane.showConfirmDialog(gamePanel, actionPanel, "Aktion für " + player.getName(), JOptionPane.OK_CANCEL_OPTION); // Zeigt das JPanel in einem JOptionPane an
            if (result == JOptionPane.OK_OPTION) { // Führt die Aktion aus, wenn der OK-Button gedrückt wird
                handleActionPanelResult(player, actionPanel); // Behandelt das Ergebnis des ActionPanels
                updatePlayerListArea(); // Aktualisiert die Anzeige der Spielerliste
            }
        });
        gamePanel.add(playerLabel); // Fügt das JLabel zum Spiel-Panel hinzu
        gamePanel.add(actionButton); // Fügt den Aktions-Button zum Spiel-Panel hinzu
    }

    /**
     * Methode zur Behandlung des Ergebnisses des Action-Panels.
     * Ruft die Methode zum Ermitteln der ausgewählten Aktion des Spielers aus dem Action-Panel auf.
     * Wenn eine Aktion ausgewählt wurde, wird die Spielerstatistik aktualisiert und die Anzeige der Spielerliste wird aktualisiert.
     */
    private void handleActionPanelResult(Player player, JPanel actionPanel) {
        String action = findSelectedRadioButtonActionCommand(actionPanel); // Ruft die Methode zum Ermitteln der ausgewählten Aktion des Spielers aus dem Action-Panel auf
        if (action != null) { // Wenn eine Aktion ausgewählt wurde
            UpdateAndIncrement.updatePlayerStats(player, action); // Aktualisiert die Spielerstatistik mit der ausgewählten Aktion
            updatePlayerListArea(); // Aktualisiert die Anzeige der Spielerliste
        }
    }

    /**
     * Methode zum Ermitteln der ausgewählten Aktion des Spielers aus dem Action-Panel.
     * Iteriert über die Komponenten im Action-Panel und sucht nach dem ausgewählten JRadioButton.
     * Wenn ein JRadioButton ausgewählt ist, wird der zugehörige ActionCommand zurückgegeben.
     * Wenn kein JRadioButton ausgewählt ist, wird null zurückgegeben.
     */
    private String findSelectedRadioButtonActionCommand(JPanel actionPanel) {
        for (Component component : actionPanel.getComponents()) { // Iteriert über die Komponenten im Action-Panel
            if (component instanceof JRadioButton) { // Sucht nach JRadioButtons
                JRadioButton radioButton = (JRadioButton) component;
                if (radioButton.isSelected()) { // Prüft, ob der JRadioButton ausgewählt ist
                    return radioButton.getActionCommand(); // Gibt den zugehörigen ActionCommand zurück
                }
            }
        }
        return null; // Wenn kein JRadioButton ausgewählt ist, wird null zurückgegeben
    }

    /**
     * Methode zum Leeren der Eingabefelder.
     * Setzt den Text der Name- und Nummern-Textfelder auf einen leeren String.
     * Setzt den Feldspieler-RadioButton auf ausgewählt und den Torhüter-RadioButton auf nicht ausgewählt.
     * Setzt den Fokus auf das Name-Textfeld.
     */
    private void clearInputFields() {
        nameField.setText(""); // Setzt den Text des Name-Textfeldes auf einen leeren String
        numberField.setText(""); // Setzt den Text des Nummern-Textfeldes auf einen leeren String
        fieldPlayerRadioButton.setSelected(true); // Setzt den Feldspieler-RadioButton auf ausgewählt
        goalkeeperRadioButton.setSelected(false); // Setzt den Torhüter-RadioButton auf nicht ausgewählt
        nameField.requestFocus(); // Setzt den Fokus auf das Name-Textfeld
    }



    /**
     * Main-Methode zum Starten der Anwendung.
     * Erstellt eine neue HandballStatsGUI und setzt sie auf sichtbar.
     */
    public static void main(String[] args) {
        HandballStatsGUI gui = new HandballStatsGUI(); // Erstellt eine neue HandballStatsGUI
        gui.setVisible(true); // Setzt die GUI auf sichtbar
    }

}