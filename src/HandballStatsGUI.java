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
    private final HashMap<String, Player> playerMap;
    private JPanel gamePanel;
    private JPanel statsPanel;

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
        // Setzen Sie das Look and Feel auf das System-Look-and-Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        // Hinzufügen von Padding um die Textfelder
        nameField.setBorder(BorderFactory.createCompoundBorder(
                nameField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        numberField.setBorder(BorderFactory.createCompoundBorder(
                numberField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        playerListArea = new JTextArea(20, 30);
        playerListArea.setEditable(false);
        playerListArea.setBorder(BorderFactory.createCompoundBorder(
                playerListArea.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Setzen Sie die maximale Größe der Textfelder
        nameField.setMaximumSize(new Dimension(200, nameField.getPreferredSize().height));
        numberField.setMaximumSize(new Dimension(200, numberField.getPreferredSize().height));

        // Farben und Schriftarten ändern
        Color bgColor = new Color(34, 49, 63);
        Color accentColor = new Color(52, 152, 219);
        Font font = new Font("Arial", Font.BOLD, 14);

        getContentPane().setBackground(bgColor);
        nameLabel.setForeground(accentColor);
        nameLabel.setFont(font);
        numberLabel.setForeground(accentColor);
        numberLabel.setFont(font);
        fieldPlayerRadioButton.setForeground(accentColor);
        fieldPlayerRadioButton.setFont(font);
        goalkeeperRadioButton.setForeground(accentColor);
        goalkeeperRadioButton.setFont(font);
        savePlayerButton.setForeground(Color.BLACK);
        savePlayerButton.setBackground(accentColor);
        startGameButton.setForeground(Color.BLACK);
        startGameButton.setBackground(accentColor);

        playerListArea.setBackground(bgColor);
        playerListArea.setForeground(accentColor);
        playerListArea.setFont(font);

        // GUI-Komponenten dem Fenster hinzufügen
        addInputPanel();
        JScrollPane scrollPane = new JScrollPane(playerListArea);
        add(scrollPane, BorderLayout.CENTER);
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
            createGoalkeeperActionPanel(actionPanel);
        } else {
            createFieldPlayerActionPanel(actionPanel);
        }
        createCommonActionPanel(actionPanel);
        return actionPanel;
    }

    private void createGoalkeeperActionPanel(JPanel actionPanel) {
        // Code für Torhüter-Aktionen
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
        // Setzen Sie für jeden JRadioButton das ActionCommand
        hitKeeperRadioButton.setActionCommand("hitByKeeper");
        missKeeperRadioButton.setActionCommand("missByKeeper");
        saveNineRadioButton.setActionCommand("saveNine");
        saveSevenRadioButton.setActionCommand("saveSeven");
        saveSixRadioButton.setActionCommand("saveSix");
        saveWingRadioButton.setActionCommand("saveWing");
        saveBreakthroughRadioButton.setActionCommand("saveBrakthrough");
        saveCounterattakRadioButton.setActionCommand("saveCounterattack");
        concededNineRadioButton.setActionCommand("concededNine");
        concededSevenRadioButton.setActionCommand("concededSeven");
        concededSixRadioButton.setActionCommand("concededSix");
        concededWingRadioButton.setActionCommand("concededWing");
        concededBreakthroughRadioButton.setActionCommand("concededBReakthrough");
        concededCounterattakRadioButton.setActionCommand("concededCounterattack");
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
    }

    // Code für Feldspieler-Aktionen
    private void createFieldPlayerActionPanel(JPanel actionPanel) {
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
        // Setzen Sie für jeden JRadioButton das ActionCommand
        goalNineRadioButton.setActionCommand("goalNine");
        goalSevenRadioButton.setActionCommand("goalSeven");
        goalSixRadioButton.setActionCommand("goalSix");
        goalWingRadioButton.setActionCommand("goalWing");
        goalBreakthroughRadioButton.setActionCommand("goalBreakthrough");
        goalCounterattakRadioButton.setActionCommand("goalCounterattack");
        missedNineRadioButton.setActionCommand("missedNine");
        missedSevenRadioButton.setActionCommand("missedSeven");
        missedSixRadioButton.setActionCommand("missedSix");
        missedWingRadioButton.setActionCommand("missedWing");
        missedBreakthroughRadioButton.setActionCommand("missedBreakthrough");
        missedCounterattakRadioButton.setActionCommand("missedCounterattack");
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

    private void createCommonActionPanel(JPanel actionPanel) {
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
        // Setzen Sie für jeden JRadioButton das ActionCommand
        lossOfBallRadioButton.setActionCommand("Ballverlust");
        ballWinRadioButton.setActionCommand("Ballgewinn");
        assistRadioButton.setActionCommand("Assist");
        technicalMistakeRadioButton.setActionCommand("Technischer Fehler");
        passCatchMistakeRadioButton.setActionCommand("Pass-& Fangfehler");
        fetchedSevenMRadioButton.setActionCommand("7m geholt");
        causedSevenMRadioButton.setActionCommand("7m verursacht");
        fetchedTwoMinutesRadioButton.setActionCommand("2 Minuten geholt");
        yellowCardRadioButton.setActionCommand("Gelbe Karte");
        twoMinutesRadioButton.setActionCommand("2 Minuten");
        redCardRadioButton.setActionCommand("Rote Karte");
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
    }

    private void handleActionPanelResult(Player player, JPanel actionPanel) {
        String action = processSelectedAction(actionPanel);

        if (action != null) {
            Aktionplus.updatePlayerStats(player, action);
            updatePlayerListArea();
        }
    }

    private String processSelectedAction(JPanel actionPanel) {
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