package GUI;

import LOGIC.buissneslogic.Statistics;
import MODEL.Player;
import LOGIC.buissneslogic.UpdateAndIncrement;
import LOGIC.create.CreatePanels;
import LOGIC.create.CreateButtons;
import LOGIC.create.CreateText;
import LOGIC.create.LookAndFeel;

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

    public HandballStatsGUI() {
        setTitle("Handball-Statistik");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initGUIComponents();

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

        savePlayerButton = CreateButtons.createButton("Spieler speichern", this);
        startGameButton = CreateButtons.createButton("Spiel starten", this);

        playerListArea = CreateText.createTextArea(20, 30);

        addInputPanel();
        JScrollPane scrollPane = new JScrollPane(playerListArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        CreateText.addLabelAndTextField(inputPanel, "Name:", nameField);
        CreateText.addLabelAndTextField(inputPanel, "Trikotnummer:", numberField);

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
        JButton statsButton = new JButton("Statistik");
        statsButton.addActionListener(e1 -> {
            handleStatsButton();
        });
        // Erstellen Sie einen weiteren JPanel, der sowohl das gamePanel als auch den statsButton enthält.
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(statsButton, BorderLayout.SOUTH);

        // Fügen Sie das mainPanel zum ContentPane hinzu, anstatt nur das gamePanel.
        getContentPane().removeAll();
        add(mainPanel);
        validate();
        repaint();
    }

    private void handleStatsButton() {
        if (statsPanel == null) {
            statsPanel = new JPanel();
            statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
            Statistics.showStats(playerMap,  statsPanel);
        }
        JFrame statsFrame = new JFrame("Statistik");
        statsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        statsFrame.getContentPane().add(statsPanel);
        statsFrame.setSize(600, 400);
        statsFrame.setLocationRelativeTo(null);
        statsFrame.setVisible(true);
    }


    private void addPlayerLabelAndActionButton(Player player) {
        String position = player.isGoalkeeper() ? "Torhüter" : "Feldspieler";
        JLabel playerLabel = new JLabel(player.getName() + " (" + position + "), Nummer " + player.getNumber());
        JButton actionButton = new JButton("Aktion");
        actionButton.addActionListener(e1 -> {
            JPanel actionPanel = CreatePanels.createActionPanel(player);
            int result = JOptionPane.showConfirmDialog(gamePanel, actionPanel, "Aktion für " + player.getName(), JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                handleActionPanelResult(player, actionPanel);
                updatePlayerListArea();
            }
        });
        gamePanel.add(playerLabel);
        gamePanel.add(actionButton);
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

    private void clearInputFields() {
        nameField.setText("");
        numberField.setText("");
        fieldPlayerRadioButton.setSelected(true);
        goalkeeperRadioButton.setSelected(false);
        nameField.requestFocus();
    }

    public static void main(String[] args) {
        HandballStatsGUI gui = new HandballStatsGUI();
        gui.setVisible(true);
    }

}