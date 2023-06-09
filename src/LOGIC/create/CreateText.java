package LOGIC.create;

import javax.swing.*;
import java.awt.*;

public class CreateText {
    // Definieren von Farben und Schriftarten, die später wiederverwendet werden können
    static Color bgColor = new Color(34, 49, 63);
    static Color accentColor = new Color(52, 152, 219);
    static Font font = new Font("Arial", Font.BOLD, 14);

    // Erstellt ein Textfeld mit der gewünschten Anzahl an Spalten
    public static JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField.setMaximumSize(new Dimension(200, textField.getPreferredSize().height));
        return textField;
    }

    // Erstellt eine Textarea mit der gewünschten Anzahl an Zeilen und Spalten
    public static JTextArea createTextArea(int rows, int columns) {
        JTextArea textArea = new JTextArea(rows, columns);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textArea.setBackground(bgColor);
        textArea.setForeground(accentColor);
        textArea.setFont(font);
        return textArea;
    }

    /**
     * Methode zum Hinzufügen eines Labels und eines Textfelds zu einem JPanel.
     * Erstellt ein neues JLabel mit dem angegebenen Text.
     * Fügt das JLabel und das angegebene JTextField dem JPanel hinzu.
     */
    public static void addLabelAndTextField(JPanel panel, String labelText, JTextField textField) {
        panel.add(new JLabel(labelText)); // Erstellt ein neues JLabel mit dem angegebenen Text und fügt es dem JPanel hinzu
        panel.add(textField); // Fügt das angegebene JTextField dem JPanel hinzu
    }
}
