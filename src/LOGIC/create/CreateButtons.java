package LOGIC.create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateButtons {

    // Konstanten für die Gestaltung der Buttons
    static Color accentColor = new Color(52, 152, 219);
    static Font font = new Font("Arial", Font.BOLD, 14);

    /**
     * Erstellt einen JRadioButton mit Text und ActionCommand und fügt ihn zu einem JPanel hinzu
     * @param actionPanel das JPanel, zu dem der RadioButton hinzugefügt wird
     * @param text der Text, der auf dem RadioButton angezeigt wird
     * @param actionCommand der ActionCommand, der dem RadioButton zugewiesen wird
     * @return der erstellte JRadioButton
     */
    public static JRadioButton createAndAddRadioButton(JPanel actionPanel, String text, String actionCommand) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setActionCommand(actionCommand);
        actionPanel.add(radioButton);
        return radioButton;
    }

    /**
     * Erstellt einen JRadioButton mit Text und Auswahlstatus
     * @param text der Text, der auf dem RadioButton angezeigt wird
     * @param selected der Auswahlstatus des RadioButtons
     * @return der erstellte JRadioButton
     */
    public static JRadioButton createRadioButton(String text, boolean selected) {
        JRadioButton radioButton = new JRadioButton(text, selected);
        radioButton.setForeground(accentColor);
        radioButton.setFont(font);
        return radioButton;
    }

    /**
     * Erstellt einen JButton mit Text und ActionListener
     * @param text der Text, der auf dem Button angezeigt wird
     * @param actionListener der ActionListener, der dem Button zugewiesen wird
     * @return der erstellte JButton
     */
    public static JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setForeground(Color.BLACK);
        button.setBackground(accentColor);
        return button;
    }
}
