package logic.create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateButtons {

    static Color accentColor = new Color(52, 152, 219);
    static Font font = new Font("Arial", Font.BOLD, 14);

    public static JRadioButton createAndAddRadioButton(JPanel actionPanel, String text, String actionCommand) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setActionCommand(actionCommand);
        actionPanel.add(radioButton);
        return radioButton;
    }

    public static JRadioButton createRadioButton(String text, boolean selected) {
        JRadioButton radioButton = new JRadioButton(text, selected);
        radioButton.setForeground(accentColor);
        radioButton.setFont(font);
        return radioButton;
    }

}
