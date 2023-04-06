package logic.create;

import javax.swing.*;
import java.awt.*;

public class CreateText {
    static Color bgColor = new Color(34, 49, 63);
    static Color accentColor = new Color(52, 152, 219);
    static Font font = new Font("Arial", Font.BOLD, 14);

    public static JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField.setMaximumSize(new Dimension(200, textField.getPreferredSize().height));
        return textField;
    }
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
}
