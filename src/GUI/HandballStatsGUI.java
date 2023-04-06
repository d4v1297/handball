package GUI;

import Model.Player;
import logic.create.CreateActionPanels;
import logic.UpdateAndIncrement;
import logic.create.CreateButtons;
import logic.create.CreateText;
import logic.create.LookAndFeel;

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

    private JButton savePlayerButton;
    private JButton startGameButton;
    private JTextArea playerListArea;
    private final HashMap<String, Player> playerMap;
    private JPanel gamePanel;
    private JPanel statsPanel;

    Color bgColor = new Color(34, 49, 63);
    static Color accentColor = new Color(52, 152, 219);
    Font font = new Font("Arial", Font.BOLD, 14);

    public HandballStatsGUI() {
        // GUI-Fenster initialisieren
        setTitle("Handball-Statistik");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // GUI-Komponenten initialisieren und hinzufügen
        initGUIComponents();

        // Spielerliste initialisieren
        playerMap = new HashMap<>();
    }

    private void initGUIComponents() {
        LookAndFeel.setLookAndFeel();

        nameField = CreateText.createTextField(20);
        numberField = CreateText.createTextField(20);

        fieldPlayerRadioButton = CreateButtons.createRadioButton("Feldspieler", true);
        goalkeeperRadioButton = CreateButtons.createRadioButton("Torhüter", false);
        ButtonGroup positionGroup = new ButtonGroup();
        positionGroup.add(fieldPlayerRadioButton);
        positionGroup.add(goalkeeperRadioButton);

        savePlayerButton = createButton("Spieler speichern");
        startGameButton = createButton("Spiel starten");

        playerListArea = CreateText.createTextArea(20, 30);

        addInputPanel();
        JScrollPane scrollPane = new JScrollPane(playerListArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    //Auslagern
    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(accentColor);
        return button;
    }

    private void addInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Trikotnummer:"));
        inputPanel.add(numberField);
        inputPanel.add(fieldPlayerRadioButton);
        inputPanel.add(goalkeeperRadioButton);
        inputPanel.add(savePlayerButton);
        inputPanel.add(startGameButton);
        add(inputPanel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == savePlayerButton) {
            handleSavePlayerButton();
        } else if (e.getSource() == startGameButton) {
            handleStartGameButton();
        }
    }
    // Methode zum Aktualisieren der Spielerliste-Anzeige
    public void updatePlayerListArea() {
        playerListArea.setText("");
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
            playerListArea.append(name + " (" + position + "), Nummer " + player.getNumber() + "\n");
        }
    }
    private void handleSavePlayerButton() {
        String name = nameField.getText();
        int number = Integer.parseInt(numberField.getText());
        boolean isGoalkeeper = goalkeeperRadioButton.isSelected();
        Player player = new Player(name, number, isGoalkeeper);
        playerMap.put(name, player);
        updatePlayerListArea();
        clearInputFields();
    }

    private void handleStartGameButton() {
        gamePanel = new JPanel(new GridLayout(playerMap.size(), 2));
        for (String name : playerMap.keySet()) {
            Player player = playerMap.get(name);
            addPlayerLabelAndActionButton(player);
        }
        JButton statsButtton = new JButton("Statistik");
        statsButtton.addActionListener(e1 -> {
            // Statistik-Button wurde geklickt
            statsPanel = new JPanel(new GridLayout(playerMap.size(), 2));
        });
        getContentPane().removeAll();
        add(gamePanel);
        validate();
        repaint();
    }

    private void addPlayerLabelAndActionButton(Player player) {
        String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
        JLabel playerLabel = new JLabel(player.getName() + " (" + position + "), Nummer " + player.getNumber());
        JButton actionButton = new JButton("Aktion");
        actionButton.addActionListener(e1 -> {
            // Aktion-Button wurde geklickt
            JPanel actionPanel = createActionPanel(player);
            int result = JOptionPane.showConfirmDialog(gamePanel, actionPanel, "Aktion für " + player.getName(), JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                handleActionPanelResult(player, actionPanel);
                updatePlayerListArea();
            }
        });
        gamePanel.add(playerLabel);
        gamePanel.add(actionButton);
    }

    private JPanel createActionPanel(Player player) {
        JPanel actionPanel = new JPanel(new GridLayout(3, 1));
        if (player.isGoalkeeper()) {
            CreateActionPanels.createGoalkeeperActionPanel(actionPanel);
        } else {
            CreateActionPanels.createFieldPlayerActionPanel(actionPanel);
        }
        CreateActionPanels.createCommonActionPanel(actionPanel);
        return actionPanel;
    }

    private void handleActionPanelResult(Player player, JPanel actionPanel) {
        String action = findSelectedRadioButtonActionCommand(actionPanel);

        if (action != null) {
            UpdateAndIncrement.updatePlayerStats(player, action);
            updatePlayerListArea();
        }
    }

    private String findSelectedRadioButtonActionCommand(JPanel actionPanel) {
        for (Component component : actionPanel.getComponents()) {
            if (component instanceof JRadioButton) {
                JRadioButton radioButton = (JRadioButton) component;
                if (radioButton.isSelected()) {
                    return radioButton.getActionCommand();
                }
            }
        }
        return null;
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